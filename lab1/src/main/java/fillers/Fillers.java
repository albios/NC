package fillers;

import java.util.*;
import sorters.ArraySorter;
import sorters.AbstractSorter;

/**
 * Class with all fillers implementations
 * @author Biloshytskyi
 */

public class Fillers {

	/**
	 * Reverses the array
	 * @param arr - array to reverse
	 */

	public static void reverse (int [] arr) {
		if (arr == null) return;
		for (int i = 0; i < arr.length / 2; i ++) {
			AbstractSorter.swap (arr, i, arr.length - i - 1);
		}
	}

	/**
	 * Creates an array of ints in ascending order
	 * @param length - length of array to create
	 * @return created array
	 */

	@filler
	public static int [] fillSorted (int length) {
		int [] arr = fillRandom (length);
		new ArraySorter().sort(arr);
		return arr;
	}

	/**
	 * Creates an array of ints in ascending order with a random number in the last position
	 * @param length - length of array to create
	 * @return created array
	 */

	@filler
	public static int [] fillSortedWithRandom (int length) {
		int [] arr = fillSorted (length);
		arr [length-1] = new Random().nextInt();
		return arr;
	}

	/**
	 * Creates an array of ints in descending order
	 * @param length - length of array to create
	 * @return created array
	 */

	@filler
	public static int [] fillSortedDesc (int length) {
		int [] arr;
		arr = fillSorted (length);
		reverse (arr);
		return arr;
	}

	/**
	 * Creates an array of ints in random order
	 * @param length - length of array to create
	 * @return created array
	 */

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
