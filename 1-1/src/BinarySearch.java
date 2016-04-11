import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Created by yunxiaozou on 3/27/16.
 */
public class BinarySearch {
    public static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length -1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if      (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else                   return mid;
        }
        return -1;
    }
    public static boolean exists(int key, int[] a) {
        return rank(key, a) < 0;
    }

    public static void main(String[] args) {

        int[] whitelist = In.readInts(args[0]);
        int[] numbers = In.readInts(args[1]);
        Arrays.sort(whitelist);
        for (int num : numbers) {
            if (rank(num, numbers) < 0)
                System.out.println(num);
        }

    }
}
