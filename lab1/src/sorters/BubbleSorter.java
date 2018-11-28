package sorters;

public class BubbleSorter extends AbstractSorter {

    public void bubbleSortForth (int arr []) {
        for (int i = 0; i < arr.length; i ++) {
            boolean sorted = true;
            for (int j = 0; j < arr.length-1-i; j ++) {
                if (arr[j] > arr[j+1]) {
                    swap (arr, j+1, j);
                    sorted = false;
                }
                if (sorted) return;
            }
        }
    }

    public void bubbleSortBack (int [] arr) {
        for (int i = 0; i <= arr.length; i ++) {
            boolean sorted = true;
            for (int j = arr.length-1; j >= i+1; j --) {
                if (arr[j-1] > arr [j]) {
                    swap (arr, j-1, j);
                    sorted = false;
                }
                if (sorted) return;
            }
        }
    }

}
