package analyzers;

public abstract class AbstractAnalyzer {
    public abstract void fillSortedAnalyzer           (int len);
    public abstract void fillSortedWithRandomAnalyzer (int len);
    public abstract void fillSortedDescAnalyzer       (int len);
    public abstract void fillRandomAnalyzer           (int len);

    public abstract long getFillSortedAnalyzerMillis();
    public abstract long getfillSortedWithRandomAnalyzerMillis();
    public abstract long getfillSortedDescAnalyzerMillis ();
    public abstract long getfillRandomAnalyzerMillis ();
}
