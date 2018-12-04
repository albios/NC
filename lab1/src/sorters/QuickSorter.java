package sorters;

public class QuickSorter extends AbstractSorter {

    public void sort (int arr [], int low, int high) {
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
            sort (arr, low, right);
        }
        if (high > left) {
            sort (arr, left, high);
        }
    }
}
