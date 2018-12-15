package fillers;

import java.util.*;
import sorters.ArraySorter;
import sorters.AbstractSorter;

public class Fillers {

	public static void reverse (int [] arr) {
		for (int i = 0; i < arr.length / 2; i ++) {
			AbstractSorter.swap (arr, i, arr.length - i - 1);
		}
	}

	@filler
	public static int [] fillSorted (int len) {
		int [] arr = new int [len];
		Random rand = new Random();
		for (int i = 0; i < len; i ++) {
			arr [i] = rand.nextInt();
		}
		new ArraySorter().sort(arr, 0, len - 1);
		return arr;
	}

	@filler
	public static int [] fillSortedWithRandom (int len) {
		int [] arr = new int [len];
		Random rand = new Random();
		for (int i = 0; i < len; i ++) {
			arr [i] = rand.nextInt();
		}
		new ArraySorter().sort(arr, 0, len - 1);
		arr [len-1] = rand.nextInt();
		return arr;
	}

	@filler
	public static int [] fillSortedDesc (int len) {
		int [] arr;
		arr = fillSorted (len);
		reverse (arr);
		return arr;
	}

	@filler
	public static int [] fillRandom (int len) {
		int [] arr = new int [len];
		Random rand = new Random();
		for (int i = 0; i < len; i ++) {
			arr [i] = rand.nextInt();
		}
		return arr;
	}
	
	public static void main(String[] args) {
		/*
		Sorters s = new Sorters ();

		s.printArray(fillSorted (5));
		s.printArray (fillSortedWithRandom(5));
		s.printArray(fillSortedDesc(5));
		s.printArray(fillRandom(5));*/
	}

}
