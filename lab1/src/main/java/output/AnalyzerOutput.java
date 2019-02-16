package output;

import analyzers.*;

/**
 * Class to print out results of counting time sorters take
 * @author Biloshytskyi
 */

public class AnalyzerOutput {

    /**
     * Prints "it took ... millisecinds" to complete
     * @param millis
     */

    public static void printTimeResult (long millis) {
        System.out.println ("It took " + millis + " milliseconds to complete");
    }

    /**
     * Prints the result of analyzing a sorter on every type of array fillers
     * @param analyzer - an object with results of analyzing
     */

    public void printAnalyzerResults (Analyzer analyzer) {
        System.out.println ("It took " + analyzer.getFillSortedAnalyzerMillis () + " milliseconds to complete sorter on sorted array");
        System.out.println ("It took " + analyzer.getFillSortedWithRandomAnalyzerMillis () + " milliseconds to complete sorter on sorted array with random at the end");
        System.out.println ("It took " + analyzer.getFillSortedDescAnalyzerMillis () + " milliseconds to complete sorter on sorted in descending order array");
        System.out.println ("It took " + analyzer.getFillRandomAnalyzerMillis () + " milliseconds to complete sorter on random array");
    }

    public void runBubbleSortForthAnalyzer (int len) {
        BubbleSortForthAnalyzer bsfa = new BubbleSortForthAnalyzer(len);
        printAnalyzerResults(bsfa);
    }

    public void runBubbleSortBackAnalyzer (int len) {
        BubbleSortBackAnalyzer bsfa = new BubbleSortBackAnalyzer(len);
        printAnalyzerResults(bsfa);
    }

    public static void main (String[] args) {
        AnalyzerOutput ao = new AnalyzerOutput();

        System.out.println ("runBubbleSortForthAnalyzer");
        ao.runBubbleSortForthAnalyzer(1000);

        System.out.println ("runBubbleSortBackAnalyzer");
        ao.runBubbleSortBackAnalyzer(1000);

    }
}
