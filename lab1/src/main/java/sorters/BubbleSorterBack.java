package sorters;

/**
 * Class for bubble sorter in reverse order
 * * @author Biloshytskyi
 */

@sorter("Bubble sorter backwards")
public class BubbleSorterBack extends BubbleSorter {

    /**
     * Sorts an array using bubble sort in reverse order
     * @param arr - an array to sotr
     */

    public void sort (int [] arr) {
        int length = arr.length;
        for (int i = 0; i <= length; i ++) {
            boolean sorted = true;
            for (int j = length-1; j >= i+1; j --) {
                if (arr[j-1] > arr [j]) {
                    swap (arr, j-1, j);
                    sorted = false;
                }
            }
            if (sorted) return;
        }
    }
}