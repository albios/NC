package sorters.merge_sorters.merge_parallel_sorters;

import sorters.ArraySorter;
import sorters.sorter;

import java.util.Arrays;

@sorter("MergeParallelArraySorter")
public class MergeParallelArraySorter extends MergeParallelSorter implements Runnable {

    int [] arr;

    public MergeParallelArraySorter () {  }

    private MergeParallelArraySorter (int [] arr) {
        this.arr = arr;
    }

    @Override
    public void run() {
        new ArraySorter().sort(arr);
    }

    @Override
    public void sort(int[] arr) {

        int [] arr1 = Arrays.copyOfRange (arr, 0, arr.length / 2);
        this.arr    = Arrays.copyOfRange (arr, arr.length / 2, arr.length);

        MergeParallelArraySorter parallelSorter = new MergeParallelArraySorter (arr1);
        Thread thread = new Thread(parallelSorter);
        thread.start();

        new ArraySorter().sort(this.arr);

        if (thread.isAlive()) {
            try {
                thread.join();
            }
            catch (Exception e) { e.printStackTrace(); }
        }

        merge (arr1, this.arr, arr);
    }

    public static void main (String [] args) {

    }
}
