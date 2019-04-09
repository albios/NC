package sorters.merge_sorters.merge_parallel_sorters;

import sorters.ArraySorter;
import sorters.bubble_sorters.BubbleSorterBack;
import sorters.sorter;

import java.util.Arrays;

@sorter("MergeParallelBubbleSorterBack")
public class MergeParallelBubbleSorterBack extends MergeParallelSorter implements Runnable {

    int [] arr;

    public MergeParallelBubbleSorterBack () {}

    private MergeParallelBubbleSorterBack (int [] arr) {
        this.arr = arr;
    }

    @Override
    public void run () { new BubbleSorterBack().sort(arr); }

    @Override
    public void sort (int [] arr) {
        int [] arr1 = Arrays.copyOfRange (arr, 0, arr.length / 2);
        this.arr    = Arrays.copyOfRange (arr, arr.length / 2, arr.length);

        MergeParallelBubbleSorterBack parallelSorter = new MergeParallelBubbleSorterBack (arr1);
        Thread thread = new Thread(parallelSorter);
        thread.start();

        new BubbleSorterBack().sort(this.arr);

        if (thread.isAlive()) {
            try {
                thread.join();
            }
            catch (Exception e) { e.printStackTrace(); }
        }

        merge (arr1, this.arr, arr);
    }
}
