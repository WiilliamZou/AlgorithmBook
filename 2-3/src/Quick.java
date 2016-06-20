import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by yunxiaozou on 6/19/16.
 */
public class Quick {
    public static void sort (Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length-1);
    }
    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }
    private static int partition(Comparable[] a, int lo, int hi) {
        int left = lo, right = hi+1;
        Comparable v = a[lo];
        while(true) {
            while(less(a[++left], v))
                if (left == hi) break;
            while(less(v, a[--right]))
                if (right == lo) break;
            if (left >= right) break;
            exch(a, left, right);
        }
        exch(a, lo, right);
        return right;
    }
    private static int partition2(Comparable[] a, int lo, int hi) {
        int left = lo, right = hi;
        int i = lo;
        Comparable v = a[lo];
        while (i <= right) {
            if (a[i].compareTo(v) < 0) {
                exch(a, left++, i++);
            } else if (a[i].compareTo(v) > 0) {
                exch(a, i, right--);
            } else {
                i++;
            }
        }
        return right;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }
}
