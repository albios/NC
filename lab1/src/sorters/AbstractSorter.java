package sorters;

public abstract class AbstractSorter {

    public static void swap (int [] arr, int ind1, int ind2) {
        int temp = arr [ind1];
        arr [ind1] = arr [ind2];
        arr [ind2] = temp;
    }

    public static void printArray (int [] arr) {
        for (int k = 0; k < arr.length; k ++) {
            System.out.print(arr[k]+" ");
        }
        System.out.println();
    }

    public int [] merge (int [] arr1, int [] arr2) {
        int ind1 = 0;
        int ind2 = 0;
        int [] arr = new int [arr1.length + arr2.length];
        int ind = 0;
        for (; ind < arr.length; ind ++) {
            if (ind1 >= arr1.length || ind2 >= arr2.length) {
                break;
            }
            if (arr1 [ind1] <= arr2 [ind2]) {
                arr [ind] = arr1 [ind1];
                ind1 ++;
            }
            else {
                arr [ind] = arr2 [ind2];
                ind2 ++;
            }
        }
        if (ind1 < arr1.length) {
            for (int i = ind1; i < arr1.length; i ++, ind ++) {
                arr [ind] = arr1 [i];
            }
        }
        else if (ind2 < arr2.length) {
            for (int i = ind2; i < arr2.length; i ++, ind ++) {
                arr [ind] = arr2 [i];
            }
        }
        return arr;
    }

    public abstract void sort (int [] arr);
}
