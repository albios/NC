package fillers;

import java.util.*;
import sorters.Sorters;

public class Filler {

	public static void reverse (int [] arr) {
		for (int i = 0; i < arr.length / 2; i ++) {
			Sorters.swap (arr, i, arr.length - i - 1);
		}
	}


	public static int [] fillSorted (int len) {
		int [] arr = new int [len];
		Random rand = new Random();
		for (int i = 0; i < len; i ++) {
			arr [i] = rand.nextInt();
		}
		Sorters.quickSort(arr, 0, len - 1);
		return arr;
	}
	
	public static int [] fillSortedWithRandom (int len) {
		int [] arr = new int [len];
		Random rand = new Random();
		for (int i = 0; i < len; i ++) {
			arr [i] = rand.nextInt();
		}
		Sorters.quickSort(arr, 0, len - 1);
		arr [len-1] = rand.nextInt();
		return arr;
	}

	public static int [] fillSortedDesc (int len) {
		int [] arr = new int [len]; 
		arr = fillSorted (len);
		reverse (arr);
		return arr;
	}
	
	public static int [] fillRandom (int len) {
		int [] arr = new int [len];
		Random rand = new Random();
		for (int i = 0; i < len; i ++) {
			arr [i] = rand.nextInt();
		}
		return arr;
	}
	
	public static void main(String[] args) {
		
		Sorters.printArray(fillSorted (5));
		Sorters.printArray (fillSortedWithRandom(5));
		Sorters.printArray(fillSortedDesc(5));
		Sorters.printArray(fillRandom(5));
	}

}
