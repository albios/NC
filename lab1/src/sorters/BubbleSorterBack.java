package sorters;

public class BubbleSorterBack extends BubbleSorter {

    public void sort (int [] arr) {
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
