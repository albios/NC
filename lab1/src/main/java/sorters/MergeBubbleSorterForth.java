package sorters;

import java.util.Arrays;

/**
 * Class for merging sorter using {@link sorters.BubbleSorterForth#sort (int []) BubbleSorterForth.sort}
 * @author Biloshytskyi
 */

@sorter("Merging bubble sorter forwards")
public class MergeBubbleSorterForth extends AbstractSorter{

    /**
     * Splits an array in two, sorts both using {@link sorters.BubbleSorterForth#sort(int[]) BubbleSorterForth.sort} and merges them in one
     * @param arr - an array to sort
     */

    @Override
    public void sort (int [] arr) {
        int [] arr1 = Arrays.copyOfRange(arr, 0, arr.length / 2);
        int [] arr2 = Arrays.copyOfRange(arr, arr.length / 2, arr.length);
        BubbleSorter s = new BubbleSorterForth ();
        s.sort(arr1);
        s.sort(arr2);
        s.merge(arr1, arr2, arr);
    }
}
