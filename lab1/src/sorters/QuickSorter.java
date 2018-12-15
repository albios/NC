package sorters;

import java.util.Arrays.*;

public class QuickSorter extends AbstractSorter {

    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length == 0) { return; }
        quickSort(arr,0, arr.length - 1);
    }

    public void quickSort (int arr [], int low, int high) {
        int left = low;
        int right = high;
        int piv = arr [(low+high) / 2];

        while (left <= right) {
            while (arr [left] < piv) {
                left ++;
            }
            while (arr [right] > piv) {
                right --;
            }
            if (left <= right) {
                Sorters.swap (arr, left, right);
                left ++;
                right --;
            }
        }
        if (low < right) {
            quickSort (arr, low, right);
        }
        if (high > left) {
            quickSort (arr, left, high);
        }
    }

    public static void main (String [] args) {
        int [] arr = {9,8,7,6,5,4,3,2,1};
        new QuickSorter ().sort (arr);
        for (int anArr : arr) System.out.println(anArr);
    }
}
