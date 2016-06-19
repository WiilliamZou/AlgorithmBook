import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by yunxiaozou on 3/17/16.
 */
public class Quick {
    public static void sort(Comparable[] a)
    {
        StdRandom.shuffle(a);
        sort(a, 0, a.length-1);
    }
    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return; //make sure more than 1 element
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

    private static boolean less(Comparable comparable, Comparable comparable1) {
        return comparable.compareTo(comparable1) < 0;
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = a[lo];
        while (true)
        {
            while (less(a[++i], v)) // when the i is not normal, we break.
                if (i == hi) break;
            // when reach the boundary, we are down.
            while (less(v, a[--j]))
                if (j == lo) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private static void exch(Comparable[] a, int i, int j)
    {
        Comparable t = a[i]; a[i] = a[j]; a[j] = t;
    }

}
