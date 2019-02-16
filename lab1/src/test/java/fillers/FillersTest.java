package fillers;

import junit.framework.TestCase;
import org.junit.Test;
import sorters.SortersTest;
import analyzers.reflection.SortersAnalyzer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

import static fillers.Fillers.fillSortedDesc;
import static fillers.Fillers.reverse;

public class FillersTest extends TestCase {

    @Test
    public void testReverse () {
        int [] arr  = {1,2,3,4,5,6,7,8,91,0};
        int [] arr1 = {1,2,3,4,5,6,7,8,49,0};
        reverse(arr);
        assertEquals(arr.length, arr1.length);

        int [] arr3 = null;
        reverse(arr3);
        assertNull(arr3);

        int [] arr4 = fillSortedDesc(1000);
        reverse (arr4);
        assertTrue(SortersTest.isSorted(arr4));
    }

    @Test
    public void testFillers () {
        Set <Method> fillers = new SortersAnalyzer().getFillers();

        for (Method filler : fillers) {
            filler.setAccessible(true);
            Object o = null;
            try {
                o = filler.invoke (null, 1000);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

            int [] arr = (int[]) o;
            assertEquals(arr.length, 1000);
        }
    }

    @Test
    public void testAllNullPointerExceptions () {
        Set <Method> fillers = new SortersAnalyzer().getFillers();
        for (Method filler : fillers) {
            testNullPointerExceptions (filler);
        }
    }

    @Test(expected = NegativeArraySizeException.class)
    public void testNullPointerExceptions (Method filler) {

            filler.setAccessible(true);
            Object o = null;
            try {
                o = filler.invoke(null, -1);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }

}
