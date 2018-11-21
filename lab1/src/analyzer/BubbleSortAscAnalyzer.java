package analyzer;

import output.AnalyzerOutput;
import sorters.Sorters;
import static fillers.Filler.*;

public class BubbleSortAscAnalyzer {

	public void fillSortedAnalyzer (int len) {
		CountTime ct = new CountTime ();
		long startCpuTimeNano = ct.getCpuTime( );

		int [] arr = fillSorted (len);
		Sorters.bubbleSortAsc(arr);

		long taskCpuTimeNano = ct.getCpuTime( ) - startCpuTimeNano;
		AnalyzerOutput.printTimeResult (taskCpuTimeNano);
	}

	public void fillSortedWithRandomAnalyzer (int len) {
		CountTime ct = new CountTime ();
		long startCpuTimeNano = ct.getCpuTime( );

		int [] arr = fillSortedWithRandom (len);
		Sorters.bubbleSortAsc(arr);

		long taskCpuTimeNano  = ct.getCpuTime( ) - startCpuTimeNano;
		AnalyzerOutput.printTimeResult (taskCpuTimeNano);
	}

	public void fillSortedDescAnalyzer (int len) {
		CountTime ct = new CountTime ();
		long startCpuTimeNano = ct.getCpuTime( );

		int [] arr = fillSortedDesc (len);
		Sorters.bubbleSortAsc(arr);

		long taskCpuTimeNano  = ct.getCpuTime( ) - startCpuTimeNano;
		AnalyzerOutput.printTimeResult (taskCpuTimeNano);
	}

	public void fillRandomAnalyzer (int len) {
		CountTime ct = new CountTime ();
		long startCpuTimeNano = ct.getCpuTime( );

		int [] arr = fillRandom (len);
		Sorters.bubbleSortAsc(arr);

		long taskCpuTimeNano  = ct.getCpuTime( ) - startCpuTimeNano;
		AnalyzerOutput.printTimeResult (taskCpuTimeNano);
	}

	public static void main(String[] args) {
		BubbleSortAscAnalyzer bsa = new BubbleSortAscAnalyzer ();

		bsa.fillSortedAnalyzer (10);
		bsa.fillSortedWithRandomAnalyzer(10);
		bsa.fillSortedDescAnalyzer(10);
		bsa.fillRandomAnalyzer(10);


	}

}
