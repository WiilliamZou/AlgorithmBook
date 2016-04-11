import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Edge;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by yunxiaozou on 3/27/16.
 */
public class EdgeWeightedDigraph {
    private final int V;
    private int E;
    private ArrayList<DirectedEdge>[] adj;

    public EdgeWeightedDigraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (ArrayList<DirectedEdge>[]) new ArrayList[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new ArrayList<>();
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(DirectedEdge e) {
        adj[e.from()].add(e);
        E++;
    }

    public Iterable<DirectedEdge> adj(int v){
        return adj[v];
    }

    public Iterable<DirectedEdge> edges() {
        ArrayList<DirectedEdge> bag = new ArrayList<DirectedEdge>();
        for (int v = 0; v < V; v++) {
            bag.addAll(adj[v]);
        }
        return bag;
    }
}
