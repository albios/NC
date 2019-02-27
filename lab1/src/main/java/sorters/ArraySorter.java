package sorters;

import java.util.Arrays;

/**
 * Class for sorting with {@link java.util.Arrays#sort(int[]) Arrays.sort}
 * @author Biloshytskyi
 */

@sorter("util.Arrays sorter")
public class ArraySorter extends AbstractSorter {

    /**
     * Sorts the array using {@link java.util.Arrays#sort(int[]) Arrays.sort}
     * @param arr - an array to sort
     *
     */

    public void sort (int [] arr) {
        Arrays.sort(arr);
    }
}
