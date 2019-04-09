package sorters.merge_sorters;

import sorters.bubble_sorters.BubbleSorter;
import sorters.bubble_sorters.BubbleSorterBack;
import sorters.sorter;

import java.util.Arrays;

/**
 * Class for merging sorter using {@link sorters.BubbleSorterBack#sort (int []) BubbleSorterBack.sort}
 * @author Biloshytskyi
 */

@sorter("MergeBubbleSorterBack")
public class MergeBubbleSorterBack extends MergeSorter {

    /**
     * Splits an array in two, sorts both using {@link sorters.BubbleSorterBack#sort(int[]) BubbleSorterBack.sort} and merges them in one
     * @param arr - an array to sort
     */

    @Override
    public void sort (int [] arr) {
        int [] arr1 = Arrays.copyOfRange (arr, 0, arr.length / 2);
        int [] arr2 = Arrays.copyOfRange(arr, arr.length / 2, arr.length);
        BubbleSorter s = new BubbleSorterBack();
        s.sort(arr1);
        s.sort(arr2);
        s.merge (arr1, arr2, arr);
    }
}
