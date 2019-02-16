package sorters;

/**
 * Root class for all sorters
 * @author Biloshytskyi
 */


public abstract class AbstractSorter {

    /**
     * Swaps to elements of given array in between two given indexes
     * @param arr  - an array to swap in
     * @param ind1 - index of first element
     * @param ind2 - index of second element
     */

    public static void swap (int [] arr, int ind1, int ind2) {
        int temp = arr [ind1];
        arr [ind1] = arr [ind2];
        arr [ind2] = temp;
    }

    /**
     * Prints out given array
     * @param arr - an array to print
     */

    public static void printArray (int [] arr) {
        for (int k = 0; k < arr.length; k ++) {
            System.out.print(arr[k]+" ");
        }
        System.out.println();
    }

    /**
     * Merges two given arrays into third given
     * @param arr1 - one of two given arrays
     * @param arr2 - one of two given arrays
     * @param toArr - an array to merge two given ones to
     */

    public void merge (int [] arr1, int [] arr2, int [] toArr) {
        if (toArr.length < arr1.length + arr2.length) toArr = new int [arr1.length + arr2.length];
        int ind1 = 0;
        int ind2 = 0;
        int ind = 0;
        for (; ind < toArr.length; ind ++) {
            if (ind1 >= arr1.length || ind2 >= arr2.length) {
                break;
            }
            if (arr1 [ind1] <= arr2 [ind2]) {
                toArr [ind] = arr1 [ind1];
                ind1 ++;
            }
            else {
                toArr [ind] = arr2 [ind2];
                ind2 ++;
            }
        }
        if (ind1 < arr1.length) {
            for (int i = ind1; i < arr1.length; i ++, ind ++) {
                toArr [ind] = arr1 [i];
            }
        }
        else if (ind2 < arr2.length) {
            for (int i = ind2; i < arr2.length; i ++, ind ++) {
                toArr [ind] = arr2 [i];
            }
        }
    }

    /**
     * A sorting function to override by classes that extend AbstractClass
     * @param arr - an array to sotr
     */

    public abstract void sort (int [] arr);
}
