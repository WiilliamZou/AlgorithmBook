import edu.princeton.cs.algs4.StdIn;

/**
 * Created by yunxiaozou on 3/27/16.
 */
public class CPM {
    public static void main(String[] args) {
        int N = StdIn.readInt();
        StdIn.readLine();
        edu.princeton.cs.algs4.EdgeWeightedDigraph G;
        edu.princeton.cs.algs4.CPM cpm;
        edu.princeton.cs.algs4.AcyclicSP sp;
        G = new edu.princeton.cs.algs4.EdgeWeightedDigraph(2*N+2);
        int s = 2*N, t = 2*N+1;

        for (int i = 0; i < N; i++) {
            String[] a = StdIn.readLine().split("\\s+");
            double duration = Double.parseDouble(a[0]);
            G.addEdge(new edu.princeton.cs.algs4.DirectedEdge(i, i+N, duration));
            G.addEdge(new edu.princeton.cs.algs4.DirectedEdge(s, i, 0.0));
            G.addEdge(new edu.princeton.cs.algs4.DirectedEdge(i+N, t, 0.0));
        }

    }
}
