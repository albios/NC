package sorters;

import java.util.Arrays;

public class MergeArraySorter extends AbstractSorter {

    @Override
    public void sort (int [] arr) {
        int [] arr1 = Arrays.copyOfRange (arr, 0, arr.length / 2);
        int [] arr2 = Arrays.copyOfRange(arr, arr.length / 2, arr.length);
        ArraySorter s = new ArraySorter ();
        s.sort(arr1);
        s.sort(arr2);
        arr = s.merge (arr1, arr2);
    }
}
