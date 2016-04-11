import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;


import java.util.PriorityQueue;

/**
 * Created by yunxiaozou on 3/20/16.
 */
public class KruskalMST {
    private Queue<Edge> mst;

    public KruskalMST(EdgeWeighedGraph G) {
        mst = new Queue<Edge>();
        MinPQ<Edge> pq = new MinPQ<Edge>();
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(G.V());
        for (Edge e : G.edges())
            pq.insert(e);

        while (!pq.isEmpty() && mst.size() < G.V()-1) {
            Edge e =  pq.delMin();
            int v = e.either(), w = e.other(v);
            if (uf.connected(v, w)) continue;
            uf.union(v, w);
            mst.enqueue(e);
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }

    public double weight() {
        double sum = 0.0;
        for (Edge edge: mst) {
            sum += edge.weight();
        }
        return sum;
    }
}