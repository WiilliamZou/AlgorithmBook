/**
 * Created by yunxiaozou on 6/19/16.
 */
public class Heapsort {
    public static void sort(Comparable[] a) {
        // sort 1-based array.
        int N = a.length;
        for (int k = N/2; k >= 1; k--)
            sink(a, k, N); //construct a heap.
        while (N > 1) {
            exch(a, 1, N--);// put the max of heap to the end of array.
            sink(a, 1, N);
        }
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i-1];
        a[i-1] = a[j-1];
        a[j-1] = temp;
    }

    private static void sink(Comparable[] a, int k, int N) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(a, j, j+1)) {
                j++;
            }
            if (!less(a, k, j)) break;
            exch(a, k, j);
            k = j;
        }
    }
    private static boolean less(Comparable[] a, int i, int j) {
        return a[i-1].compareTo(a[j-1]) < 0;
    }
}
