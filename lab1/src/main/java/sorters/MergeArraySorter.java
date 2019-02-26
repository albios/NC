package sorters;

import java.util.Arrays;

/**
 * Class for merging sorter using {@link sorters.ArraySorter#sort (int []) ArraySorter.sort}
 * @author Biloshytskyi
 */

@sorter("Merging util.Arrays sorter")
public class MergeArraySorter extends AbstractSorter {

    /**
     * Splits an array in two, sorts both using {@link sorters.ArraySorter#sort(int[]) ArraySorter.sort} and merges them in one
     * @param arr - an array to sort
     */

    @Override
    public void sort (int [] arr) {
        int [] arr1 = Arrays.copyOfRange (arr, 0, arr.length / 2);
        int [] arr2 = Arrays.copyOfRange (arr, arr.length / 2, arr.length);
        ArraySorter s = new ArraySorter ();
        s.sort(arr1);
        s.sort(arr2);
        s.merge (arr1, arr2, arr);
    }
}