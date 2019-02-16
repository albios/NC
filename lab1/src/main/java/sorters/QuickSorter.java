package sorters;

/**
 * Class for sorter using QuickSort
 * @author Biloshytskyi
 * @see <a href="https://en.wikipedia.org/wiki/Quicksort">QuickSort</a>
 */

public class QuickSorter extends AbstractSorter {

    /**
     * Sorts an array using QuickSort. It calls recursive function {@link sorters.QuickSorter#quickSort(int[], int, int) quickSort}
     * @param arr - an array to sort
     */

    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length == 0) return;
        quickSort(arr,0, arr.length - 1);
    }

    /**
     * Recursive function that sorts an array using QuickSort algorithm
     * @param arr
     * @param low
     * @param high
     */

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
                AbstractSorter.swap (arr, left, right);
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

    }
}
