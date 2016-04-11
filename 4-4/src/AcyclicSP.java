import edu.princeton.cs.algs4.*;

import java.util.ArrayList;

/**
 * Created by yunxiaozou on 3/27/16.
 */
public class AcyclicSP {
    private edu.princeton.cs.algs4.DirectedEdge[] edgeTo;
    private double[] distTo;
    private final int s;

    public AcyclicSP(edu.princeton.cs.algs4.EdgeWeightedDigraph G, int s) {
        this.s = s;
        edgeTo = new edu.princeton.cs.algs4.DirectedEdge[G.V()];
        distTo = new double[G.V()];

        for (int v = 0; v < G.V(); v++)
            distTo[v] = Double.POSITIVE_INFINITY;
        distTo[s] = 0.0;

        Topological top = new Topological(G);

        for (int v : top.order())
            relax(G, v);
    }

    private void relax(edu.princeton.cs.algs4.EdgeWeightedDigraph G, int v) {
        for (edu.princeton.cs.algs4.DirectedEdge e: G.adj(v)) {
            int w = e.to();
            if (distTo[w] > distTo[v] + e.weight()) {
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
            }
        }
    }

    public double distTo(int v) {
        return distTo[v];
    }

    public boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    public Iterable<edu.princeton.cs.algs4.DirectedEdge> pathTo(int v) {
        if (distTo[v] == Double.POSITIVE_INFINITY) {
            return new ArrayList<edu.princeton.cs.algs4.DirectedEdge>();
        } else {
            Stack<edu.princeton.cs.algs4.DirectedEdge> stack = new Stack<edu.princeton.cs.algs4.DirectedEdge>();
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
