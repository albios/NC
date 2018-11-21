package analyzer;
import java.lang.management.*;

public class CountTime {

    /** Get CPU time in nanoseconds. */
    public long getCpuTime( ) {
        return System.nanoTime( );
    }
}
