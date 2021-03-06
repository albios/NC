package analyzers;

import sorters.bubble_sorters.BubbleSorterForth;
import fillers.Fillers;

public class BubbleSortForthAnalyzer extends Analyzer {
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

	public BubbleSortForthAnalyzer (int len) {
		fillSortedAnalyzer (len);
		fillSortedWithRandomAnalyzer (len);
		fillSortedDescAnalyzer (len);
		fillRandomAnalyzer (len);
	}

	@Override
	public void fillSortedAnalyzer (int len) {
        int [] arr = Fillers.fillSorted (len);

        long startCpuTime = CountTime.getCpuTime();
		new BubbleSorterForth().sort(arr);

		fillSortedAnalyzerMillis = CountTime.getCpuTime() - startCpuTime;
	}

	@Override
	public void fillSortedWithRandomAnalyzer (int len) {
		int [] arr = Fillers.fillSortedWithRandom (len);

        long startCpuTime = CountTime.getCpuTime();
        new BubbleSorterForth().sort(arr);

		fillSortedWithRandomAnalyzerMillis = CountTime.getCpuTime() - startCpuTime;
	}

	@Override
	public void fillSortedDescAnalyzer (int len) {
		int [] arr = Fillers.fillSortedDesc (len);

        long startCpuTime = CountTime.getCpuTime();
        new BubbleSorterForth().sort(arr);

		fillSortedDescAnalyzerMillis = CountTime.getCpuTime() - startCpuTime;
	}

	@Override
	public void fillRandomAnalyzer (int len) {
		int [] arr = Fillers.fillRandom (len);

        long startCpuTime = CountTime.getCpuTime();
        new BubbleSorterForth().sort(arr);

		fillRandomAnalyzerMillis = CountTime.getCpuTime() - startCpuTime;
	}


	public static void main(String[] args) {
		/*BubbleSortForthAnalyzer bsa = new BubbleSortForthAnalyzer ();

		bsa.fillSortedAnalyzer (1000);
		bsa.fillSortedWithRandomAnalyzer(1000);
		bsa.fillSortedDescAnalyzer(1000);
		bsa.fillRandomAnalyzer(1000);*/
	}

}
