package output;
//import analyzers.BubbleSortBackAnalyzer;
import analyzers.*;

public class AnalyzerOutput {

    public static void printTimeResult (long millis) {
        System.out.println ("It took " + millis + " milliseconds to complete");
    }

    public void printAnalyzerResults (AbstractAnalyzer analyzer) {
        System.out.println ("It took " + analyzer.getFillSortedAnalyzerMillis () + " milliseconds to complete sorter on sorted array");
        System.out.println ("It took " + analyzer.getfillSortedWithRandomAnalyzerMillis () + " milliseconds to complete sorter on sorted array with random at the end");
        System.out.println ("It took " + analyzer.getfillSortedDescAnalyzerMillis () + " milliseconds to complete sorter on sorted in descending order array");
        System.out.println ("It took " + analyzer.getfillRandomAnalyzerMillis () + " milliseconds to complete sorter on random array");
    }

    public void analyzeBubbleSortForthAnalyzer (int len) {
        BubbleSortForthAnalyzer bsfa = new BubbleSortForthAnalyzer(len);
        printAnalyzerResults(bsfa);
    }

    public static void main (String[] args) {
        AnalyzerOutput ao = new AnalyzerOutput();
        ao.analyzeBubbleSortForthAnalyzer(1000);

    }
}
