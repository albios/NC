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
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.charts.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBoolean;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea;
import sorters.sorter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.sound.sampled.Line;

public class ExcelOutput {

    XSSFWorkbook workbook = new XSSFWorkbook();
    private static final String FILE_NAME = "tmp/SortersComparison.xlsx";
    private Set <Class>  sorters = new SortersAnalyzer().getSorters();
    private Set <Method> fillers = new SortersAnalyzer().getFillers();
    private int NUM_OF_COLUMNS = 0;

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
        NUM_OF_COLUMNS = 0;
        for (int length = 5000; length <= 100000; length += 5000, NUM_OF_COLUMNS ++) {
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
        createChart (sheet);
    }

    public void createChart (XSSFSheet sheet) {
        Drawing drawing = sheet.createDrawingPatriarch();
        ClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 15, 5, NUM_OF_COLUMNS + 15, 20);

        Chart chart = drawing.createChart(anchor);
        ChartLegend legend = chart.getOrCreateLegend();
        legend.setPosition(LegendPosition.RIGHT);

        LineChartData data = chart.getChartDataFactory().createLineChartData();

        ChartAxis bottomAxis = chart.getChartAxisFactory().createCategoryAxis(AxisPosition.BOTTOM);
        ValueAxis leftAxis = chart.getChartAxisFactory().createValueAxis(AxisPosition.LEFT);
        leftAxis.setCrosses(AxisCrosses.AUTO_ZERO);

        ChartDataSource<Number>  xs = DataSources.fromNumericCellRange(sheet, new CellRangeAddress(1, NUM_OF_COLUMNS, 0, 0));
        ChartDataSource<Number> [] ys = new ChartDataSource[sorters.size()];
        for (int i = 0; i < ys.length; i ++) ys [i] = DataSources.fromNumericCellRange(sheet, new CellRangeAddress (1, NUM_OF_COLUMNS, i+1, i+1));

        LineChartSeries[] series = new LineChartSeries[ys.length];
        int ind = 0;
        for (Class sorter : sorters) {
            series[ind] = data.addSeries(xs, ys[ind]);
            series[ind].setTitle(getSorterName(sorter));
            ind ++;
        }

        chart.plot(data, bottomAxis, leftAxis);

        XSSFChart xssfChart = (XSSFChart) chart;
        CTPlotArea plotArea = xssfChart.getCTChart().getPlotArea();
        plotArea.getLineChartArray()[0].getSmooth();
        CTBoolean ctBool = CTBoolean.Factory.newInstance();
        ctBool.setVal(false);
        plotArea.getLineChartArray()[0].setSmooth(ctBool);
        for (CTLineSer ser : plotArea.getLineChartArray()[0].getSerArray()) {
            ser.setSmooth(ctBool);
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
