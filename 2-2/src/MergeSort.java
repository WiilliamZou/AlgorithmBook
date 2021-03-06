/**
 * Created by yunxiaozou on 6/19/16.
 */
public class MergeSort {
    private Comparable[] aux;
    public void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length-1);
    }
    public void sort (Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi-lo)/2;
        sort(a, lo, mid);
        sort(a, mid+1, hi);
        merge(a, lo, mid, hi);
    }
    public void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo, j = mid+1;
        for (int k =  lo; k <= hi; k++)
            aux[k] = a[k];
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[i++];
            else                           a[k] = aux[i++];
        }
    }
    private boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }
}
