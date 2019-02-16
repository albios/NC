package analyzers;

/**
 * Class for counting time sorters are taking
 * @author Biloshytskyi
 */

public class CountTime {

    /**
     * @return CPU time in nanoseconds.
     */

    public static long getCpuTime( ) {
        return System.nanoTime();
    }
}
