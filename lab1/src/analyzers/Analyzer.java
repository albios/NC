package analyzers;

public abstract class Analyzer {
    public abstract void fillSortedAnalyzer           (int len);
    public abstract void fillSortedWithRandomAnalyzer (int len);
    public abstract void fillSortedDescAnalyzer       (int len);
    public abstract void fillRandomAnalyzer           (int len);

    public abstract long getFillSortedAnalyzerMillis();
    public abstract long getFillSortedWithRandomAnalyzerMillis();
    public abstract long getFillSortedDescAnalyzerMillis ();
    public abstract long getFillRandomAnalyzerMillis ();
}
