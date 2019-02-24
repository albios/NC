package analyzers.reflection;

import analyzers.CountTime;
import fillers.filler;
import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import sorters.AbstractSorter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Set;

/**
 * Class for analyzing all kinds of sorters with all types of fillers
* @author Biloshytskyi
 */

public class SortersAnalyzer {

    /**
     * @return A Set of classes (sorters implementations) that extend AbstractSorter
     * @see <a href="java.lang.Class">Class</a>
     */

    public Set getSorters () {
        Reflections reflections = new Reflections("sorters");
        Set <Class<? extends AbstractSorter>> sorters = reflections.getSubTypesOf(AbstractSorter.class);
        HashSet <Class> abstractSorters = new HashSet ();
        for (Class sorter : sorters) if (Modifier.isAbstract(sorter.getModifiers())) abstractSorters.add(sorter);
        for (Class sorter : abstractSorters) sorters.remove(sorter);
        return sorters;
    }

    /**
     * @return A Set of methods (array fillers implementations) marked with @filler annotation
     * @see <a href="java.lang.Method">Method</a>
     */

    public Set getFillers () {
        Reflections reflections = new Reflections("fillers", new MethodAnnotationsScanner());
        Set <Method> fillers = reflections.getMethodsAnnotatedWith(filler.class);
        return fillers;
    }

    /**
     * @param length                        length of arrays to analyze
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     *
     * Finds all array fillers using {@link #getFillers () getFillers} and all array sorters using {@link #getSorters () getSorters}<br>
     * runs every sorter with array from every filler and prints out time result
     */

    public static long runSorter (Class sorter, int [] arr) {
        long startCpuTime = CountTime.getCpuTime();
        Class [] cArg = {int[].class};
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
        return CountTime.getCpuTime() - startCpuTime;
    }

    public void runSorters (int length) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Set <Method> fillers = getFillers();
        Set <Class>  sorters = getSorters();
        for (Method filler : fillers) {
            System.out.println ("filler is " + filler.getName());
            for (Class sorter : sorters) {
                filler.setAccessible(true);

                Object o = filler.invoke(null, length);
                int [] arr = (int[]) o;

                long millis = runSorter (sorter, arr);
                System.out.println ("\tsorter is " + sorter.getName() + ", took " + millis / 1000.0+ " nanoseconds to sort");
//                AbstractSorter.printArray(arr);
            }
        }
    }

    public static void main (String args []) {

        SortersAnalyzer sa = new SortersAnalyzer();
        try {
            sa.runSorters(10000);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


        }

}
