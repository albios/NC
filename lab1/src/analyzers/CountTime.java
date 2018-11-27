package analyzers;
import java.lang.management.*;

public class CountTime {

    /** Get CPU time in nanoseconds. */
    public static long getCpuTime( ) {
        return System.currentTimeMillis();
    }
}
