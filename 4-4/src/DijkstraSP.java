import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.Stack;

import java.util.ArrayList;

/**
 * Created by yunxiaozou on 3/27/16.
 */
public class DijkstraSP {
    private DirectedEdge[] edgeTo;
    private double[] distTo;
    private IndexMinPQ<Double> pq;
    private final int s;

    public DijkstraSP(EdgeWeightedDigraph G, int s) {
        this.s = s;
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];
        pq = new IndexMinPQ<Double>(G.V());

        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0.0;

        pq.insert(s, 0.0);
        while (!pq.isEmpty()) {
            relax(G, pq.delMin());
        }
    }

    private void relax(EdgeWeightedDigraph G, int v){
        for (DirectedEdge e: G.adj(v)) {
            int w = e.to();
            if (distTo[w] > distTo[v] + e.weight()) {
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
                if (pq.contains(w)) pq.changeKey(w, distTo[w]);
                else                pq.insert(w, distTo[w]);
            }
        }
    }

    public double distTo(int v) {
        return distTo[v];
    }

    public boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    public Iterable<DirectedEdge> pathTo(int v) {
        if (distTo[v] == Double.POSITIVE_INFINITY) {
            return new ArrayList<DirectedEdge>();
        } else {
            Stack<DirectedEdge> stack = new Stack<DirectedEdge>();
            int to = v;
            while (edgeTo[to].from() != s) {
                stack.push(edgeTo[to]);
                to = edgeTo[to].from();
            }
            stack.push(edgeTo[to]);
            return stack;
        }
    }
}
