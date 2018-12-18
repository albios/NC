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
	public static int [] fillSorted (int length) {
		int [] arr = new int [length];
		Random rand = new Random();
		for (int i = 0; i < length; i ++) {
			arr [i] = rand.nextInt();
		}
		new ArraySorter().sort(arr);
		return arr;
	}

	@filler
	public static int [] fillSortedWithRandom (int length) {
		int [] arr = new int [length];
		Random rand = new Random();
		for (int i = 0; i < length; i ++) {
			arr [i] = rand.nextInt();
		}
		new ArraySorter().sort(arr);
		arr [length-1] = rand.nextInt();
		return arr;
	}

	@filler
	public static int [] fillSortedDesc (int length) {
		int [] arr;
		arr = fillSorted (length);
		reverse (arr);
		return arr;
	}

	@filler
	public static int [] fillRandom (int length) {
		int [] arr = new int [length];
		Random rand = new Random();
		for (int i = 0; i < length; i ++) {
			arr [i] = rand.nextInt();
		}
		return arr;
	}
	
	public static void main(String[] args) {

	}

}
