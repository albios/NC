package analyzers;

import sorters.BubbleSorterBack;
import fillers.Filler;

public class BubbleSortBackAnalyzer extends Analyzer {
    private long fillSortedAnalyzerMillis;
    private long fillSortedWithRandomAnalyzerMillis;
    private long fillSortedDescAnalyzerMillis;
    private long fillRandomAnalyzerMillis;

    public long getFillSortedAnalyzerMillis () {
        return fillSortedAnalyzerMillis;
    }

    public long getFillSortedWithRandomAnalyzerMillis () {
        return fillSortedWithRandomAnalyzerMillis;
    }

    public long getFillSortedDescAnalyzerMillis () {
        return fillSortedDescAnalyzerMillis;
    }

    public long getFillRandomAnalyzerMillis () {
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
        int [] arr = Filler.fillSorted (len);

        long startCpuTime = CountTime.getCpuTime();
        new BubbleSorterBack().sort(arr);

        fillSortedAnalyzerMillis = CountTime.getCpuTime() - startCpuTime;
    }

    @Override
    public void fillSortedWithRandomAnalyzer (int len) {
        int [] arr = Filler.fillSortedWithRandom (len);

        long startCpuTime = CountTime.getCpuTime();
        new BubbleSorterBack().sort(arr);

        fillSortedWithRandomAnalyzerMillis = CountTime.getCpuTime() - startCpuTime;
    }

    @Override
    public void fillSortedDescAnalyzer (int len) {
        int [] arr = Filler.fillSortedDesc (len);

        long startCpuTime = CountTime.getCpuTime();
        new BubbleSorterBack().sort(arr);

        fillSortedDescAnalyzerMillis = CountTime.getCpuTime() - startCpuTime;
    }

    @Override
    public void fillRandomAnalyzer (int len) {
        int [] arr = Filler.fillRandom (len);

        long startCpuTime = CountTime.getCpuTime();
        new BubbleSorterBack().sort(arr);

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
