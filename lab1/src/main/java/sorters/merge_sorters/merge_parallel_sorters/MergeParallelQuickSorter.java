package sorters.merge_sorters.merge_parallel_sorters;

import sorters.QuickSorter;
import sorters.sorter;

import java.util.Arrays;

@sorter("MergeParallelQuickSorter")
public class MergeParallelQuickSorter extends MergeParallelSorter implements Runnable {

    int [] arr;

    public MergeParallelQuickSorter () {  }

    private MergeParallelQuickSorter (int [] arr) {
        this.arr = arr;
    }

    @Override
    public void run() {
        new QuickSorter().sort(arr);
    }

    @Override
    public void sort(int[] arr) {

        int [] arr1 = Arrays.copyOfRange (arr, 0, arr.length / 2);
        this.arr    = Arrays.copyOfRange (arr, arr.length / 2, arr.length);

        MergeParallelQuickSorter parallelSorter = new MergeParallelQuickSorter (arr1);
        Thread thread = new Thread(parallelSorter);
        thread.start();

        new QuickSorter().sort(this.arr);

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
