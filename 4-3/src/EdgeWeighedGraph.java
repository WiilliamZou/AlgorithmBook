import edu.princeton.cs.algs4.In;


import java.util.ArrayList;

/**
 * Created by yunxiaozou on 3/20/16.
 */
public class EdgeWeighedGraph {
    private final int V;
    private int E;
    private ArrayList<Edge>[] adj;

    public EdgeWeighedGraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (ArrayList<Edge>[]) new ArrayList[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new ArrayList<Edge>();
        }
    }

    public int V() {
        return V;
    }
    public int E() {
        return E;
    }

    public void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }


    public Iterable<Edge> adj(int v) {
        return adj[v];
    }

    public Iterable<Edge> edges() {
        ArrayList<Edge> b = new ArrayList<Edge>();
        for (int v = 0; v < V; v++) {
            for (Edge e : adj[v])
                if (e.other(v) > v)
                    b.add(e);
        }
        return b;
    }
}

