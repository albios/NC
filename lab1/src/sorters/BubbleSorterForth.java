package sorters;

public class BubbleSorterForth extends BubbleSorter {
    public void sort (int [] arr) {
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
}
