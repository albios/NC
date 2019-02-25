package sorters;

/**
 * Class for bubble sorter in direct order
 * * @author Biloshytskyi
 */

@sorter("Bubble sorter forwards")
public class BubbleSorterForth extends BubbleSorter {

    /**
     * Sorts an array using bubble sort in direct order
     * @param arr - an array to sotr
     */

    public void sort (int [] arr) {
        for (int i = 0; i < arr.length - 1; i ++) {
            boolean sorted = true;
            for (int j = 0; j < arr.length - i - 1; j ++) {
                if (arr[j] > arr[j+1]) {
                    swap (arr, j+1, j);
                    sorted = false;
                }
            }
            if (sorted) return;
        }
    }
}
