package excelOutput;

import analyzers.reflection.SortersAnalyzer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

import fillers.filler;
import sorters.sorter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelOutput {

    XSSFWorkbook workbook = new XSSFWorkbook();
    private static final String FILE_NAME = "tmp/SortersComparison.xlsx";
    Set <Class>  sorters = new SortersAnalyzer().getSorters();
    Set <Method> fillers = new SortersAnalyzer().getFillers();

    public String getFillerName (Method filler) {
        return filler.getAnnotation(filler.class).value();
    }
    public String getSorterName (Class sorter)   {
        return ((sorter) sorter.getAnnotation(sorter.class)).value();
    }

    public void createTab (Method filler) {
        XSSFSheet sheet = workbook.createSheet(getFillerName(filler));

        int rowNum = 0;
        Row row = sheet.createRow(rowNum++);

        int colNum = 0;
        Cell cell = row.createCell (colNum++);
        cell.setCellValue("Milliseconds");
        for (Class sorter : sorters) {
            cell = row.createCell(colNum++);
            cell.setCellValue(getSorterName(sorter));
        }

        for (int i = 0; i < colNum + 1; i ++) sheet.autoSizeColumn (i);

        for (int length = 5000; length <= 100000; length += 5000) {
            row = sheet.createRow(rowNum++);
            colNum = 0;
            cell = row.createCell(colNum++);
            cell.setCellValue (length);
            Object o = null;
            try {
                o = filler.invoke(null, length);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            int [] arr = (int[]) o;
            for (Class sorter : sorters) {
                cell = row.createCell(colNum ++);
                int [] arr1 = arr.clone();
                cell.setCellValue(SortersAnalyzer.runSorter(sorter, arr1) / 1000000.0);
            }
        }

    }

    public static void main (String[] args) {

        ExcelOutput out = new ExcelOutput();

        for (Method filler : out.fillers) {
            out.createTab(filler);
            System.out.println(out.getFillerName(filler) + " tab done");
        }

        try {
            FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
            out.workbook.write(outputStream);
            out.workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
