


import java.util.LinkedList;
import edu.princeton.cs.algs4.Queue;


/**
 * Created by yunxiaozou on 3/18/16.
 */
public class BinarySearchST <Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private Value[] vals;
    private int N;

    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
    }

    public int size() {
        return N;
    }

    public Value get(Key key) {
        if (isEmpty()) return null;
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) return vals[i];
        else                                      return null;
    }

    public int rank(Key key) {
        return rank(key, 0, N);
    }

    public void put(Key key, Value val) {
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            vals[i] = val;
            return;
        }
        for (int j = N; j > i; j--) {
            keys[j] = keys[j-1];
            vals[j] = vals[j-1];
        }
        keys[i] = key;
        vals[i] = val;
        N++;
    }

    public  boolean isEmpty() {
        return size() == 0;
    }

    public int rank(Key key, int lo, int hi) {
        if (hi < lo) return lo;
        int mid = lo + (hi -lo) / 2;
        int cmp = key.compareTo(keys[mid]);
        if (cmp < 0)
            return rank(key, lo, mid-1);
        else if (cmp > 0)
            return rank(key, mid+1, hi);
        else return mid;
    }

    public Key min() {
        return keys[0];
    }

    public Key max() {
        return keys[N-1];
    }

    public Key select(int k) {
        return keys[k];
    }

    public Key ceiling (Key key) {
        int i = rank(key);
        //need to check....
        if (i >= 0 && i < N)
            return keys[i];
        else
            return null;
    }

    public Key floor(Key key) {
        int i = rank(key);
        if (i >= 0 && i < N && key.compareTo(keys[i]) == 0 )
            return keys[i];
        else {
            if (i-1 >= 0)
                return keys[i-1];
            else
                return null;
        }
    }

    public Key delete(Key key) {
        int i = rank(key);
        if (i > N)
            return null;
        Key result = keys[i];
        for (int j = i+1; j < N; j++) {
            keys[j-1] = keys[j];
            vals[j-1] = vals[j-1];
        }
        keys[N] = null;
        vals[N] = null;
        N--;
        return result;
    }

    public Iterable<Key> keys (Key lo, Key hi) {
        Queue<Key> q = new Queue<>();
        for (int i = rank(lo); i < rank(hi); i++)
            q.enqueue(keys[i]);
        if (contains(hi))
            q.enqueue(keys[rank(hi)]);
        return q;
    }

    private boolean contains(Key hi) {
        return ceiling(hi).compareTo(hi) == 0;
    }
}
