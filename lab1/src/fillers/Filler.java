package fillers;

import java.util.*;
import sorters.Sorters;
import sorters.AbstractSorter;

public class Filler {

	public static void reverse (int [] arr) {
		for (int i = 0; i < arr.length / 2; i ++) {
			AbstractSorter.swap (arr, i, arr.length - i - 1);
		}
	}


	public int [] fillSorted (int len) {
		int [] arr = new int [len];
		Random rand = new Random();
		for (int i = 0; i < len; i ++) {
			arr [i] = rand.nextInt();
		}
		new Sorters().quickSort(arr, 0, len - 1);
		return arr;
	}
	
	public int [] fillSortedWithRandom (int len) {
		int [] arr = new int [len];
		Random rand = new Random();
		for (int i = 0; i < len; i ++) {
			arr [i] = rand.nextInt();
		}
		new Sorters().quickSort(arr, 0, len - 1);
		arr [len-1] = rand.nextInt();
		return arr;
	}

	public int [] fillSortedDesc (int len) {
		int [] arr;
		arr = fillSorted (len);
		reverse (arr);
		return arr;
	}
	
	public int [] fillRandom (int len) {
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
