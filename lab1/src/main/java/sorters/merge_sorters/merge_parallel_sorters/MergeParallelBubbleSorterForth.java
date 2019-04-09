package sorters.merge_sorters.merge_parallel_sorters;

import sorters.bubble_sorters.BubbleSorterForth;
import sorters.merge_sorters.MergeBubbleSorterForth;
import sorters.bubble_sorters.BubbleSorterBack;
import sorters.sorter;

import java.util.Arrays;

@sorter("MergeParallelBubbleSorterForth")
public class MergeParallelBubbleSorterForth extends MergeParallelSorter implements Runnable {

    int [] arr;

    public MergeParallelBubbleSorterForth () {}

    private MergeParallelBubbleSorterForth (int [] arr) {
        this.arr = arr;
    }

    @Override
    public void run () { new BubbleSorterForth().sort(arr); }

    @Override
    public void sort (int [] arr) {
        int [] arr1 = Arrays.copyOfRange (arr, 0, arr.length / 2);
        this.arr    = Arrays.copyOfRange (arr, arr.length / 2, arr.length);

        MergeParallelBubbleSorterForth parallelSorter = new MergeParallelBubbleSorterForth (arr1);
        Thread thread = new Thread(parallelSorter);
        thread.start();

        new BubbleSorterForth().sort(this.arr);

        if (thread.isAlive()) {
            try {
                thread.join();
            }
            catch (Exception e) { e.printStackTrace(); }
        }

        merge (arr1, this.arr, arr);
    }
}
