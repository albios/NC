package sorters;

import analyzers.reflection.SortersAnalyzer;
import junit.framework.TestCase;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class SortersTest extends TestCase {

    @Test
    public static boolean isSorted (int [] arr) {
        if (arr == null) return true;
        for (int i = 0; i < arr.length - 1; i ++) if (arr[i] > arr[i+1]) return false;
        return true;
    }

    public void testAllSorters () {
        Set<Class> sorters = new SortersAnalyzer().getSorters();
        Class [] cArg = {int[].class};
        for (Class sorter : sorters) {
            int [] arr = {9,8,7,6,5,4,3,2,1};
            try {
                sorter.getMethod("sort", cArg).invoke(sorter.getDeclaredConstructor().newInstance(null), arr);
            } catch (Exception e) {
                e.printStackTrace();
            }
            assertTrue (isSorted (arr));
        }
    }

    @Test
    public void testIsSorted () {
        int [] arr = {1,2,3,4,5,6,7,8,9};
        assertTrue(isSorted(arr));
        int [] arr1 = {};
        assertTrue(isSorted(arr1));
        arr[3] = 211;
        assertFalse(isSorted(arr));
    }

    @Test
    public void testAllNullPointerExceptions () {
        Set<Class> sorters = new SortersAnalyzer().getSorters();
        for (Class sorter : sorters) testNullPointerException(sorter);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testNullPointerException (Class sorter) {
        Class [] cArg = {int[].class};
        int [] arr = null;

            try {
                sorter.getMethod("sort", cArg).invoke(sorter.getDeclaredConstructor().newInstance(null), arr);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
            thrown.expect(NullPointerException.class);
    }

}
