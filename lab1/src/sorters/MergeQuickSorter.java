package sorters;

import java.util.Arrays;

public class MergeQuickSorter extends AbstractSorter {

    @Override
    public void sort (int [] arr) {
        int [] arr1 = Arrays.copyOfRange (arr, 0, arr.length/ 2);
        int [] arr2 = Arrays.copyOfRange (arr, arr.length / 2, arr.length);
        QuickSorter s = new QuickSorter ();
        s.sort (arr1, 0, arr1.length - 1);
        s.sort (arr2, 0, arr2.length - 1);
        arr = s.merge (arr1, arr2);
    }
}
