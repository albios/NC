package analyzers;

import output.AnalyzerOutput;
import sorters.Sorters;
import fillers.Filler;

public class BubbleSortBackAnalyzer extends AbstractAnalyzer {
    private long fillSortedAnalyzerMillis;
    private long fillSortedWithRandomAnalyzerMillis;
    private long fillSortedDescAnalyzerMillis;
    private long fillRandomAnalyzerMillis;

    public long getFillSortedAnalyzerMillis () {
        return fillSortedAnalyzerMillis;
    }

    public long getfillSortedWithRandomAnalyzerMillis () {
        return fillSortedWithRandomAnalyzerMillis;
    }

    public long getfillSortedDescAnalyzerMillis () {
        return fillSortedDescAnalyzerMillis;
    }

    public long getfillRandomAnalyzerMillis () {
        return fillRandomAnalyzerMillis;
    }

    public BubbleSortBackAnalyzer (int len) {
        fillSortedAnalyzer (len);
        fillSortedWithRandomAnalyzer (len);
        fillSortedDescAnalyzer (len);
        fillRandomAnalyzer (len);
    }

    @Override
    public void fillSortedAnalyzer (int len) {
        int [] arr = new Filler().fillSorted (len);

        long startCpuTime = CountTime.getCpuTime();
        new Sorters().bubbleSortBack(arr);

        fillSortedAnalyzerMillis = CountTime.getCpuTime() - startCpuTime;
    }

    @Override
    public void fillSortedWithRandomAnalyzer (int len) {
        int [] arr = new Filler().fillSortedWithRandom (len);

        long startCpuTime = CountTime.getCpuTime();
        new Sorters().bubbleSortBack(arr);

        fillSortedWithRandomAnalyzerMillis = CountTime.getCpuTime() - startCpuTime;
    }

    @Override
    public void fillSortedDescAnalyzer (int len) {
        int [] arr = new Filler().fillSortedDesc (len);

        long startCpuTime = CountTime.getCpuTime();
        new Sorters().bubbleSortBack(arr);

        fillSortedDescAnalyzerMillis = CountTime.getCpuTime() - startCpuTime;
    }

    @Override
    public void fillRandomAnalyzer (int len) {
        int [] arr = new Filler().fillRandom (len);

        long startCpuTime = CountTime.getCpuTime();
        new Sorters().bubbleSortBack(arr);

        fillRandomAnalyzerMillis = CountTime.getCpuTime() - startCpuTime;
    }


    public static void main(String[] args) {
        /*BubbleSortBackAnalyzer bsa = new BubbleSortBackAnalyzer ();

        bsa.fillSortedAnalyzer (1000);
        bsa.fillSortedWithRandomAnalyzer(1000);
        bsa.fillSortedDescAnalyzer(1000);
        bsa.fillRandomAnalyzer(1000);*/
    }


}
