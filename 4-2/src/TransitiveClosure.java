/**
 * Created by yunxiaozou on 3/26/16.
 */
public class TransitiveClosure {
    private DirectedDFS[] all;
    TransitiveClosure(Digraph G) {
        all = new DirectedDFS[G.V()];
        for (int v = 0; v < G.V(); v++)
            all[v] = new DirectedDFS(G, v);
    }

    boolean reachable(int v, int w) {
        return all[v].makred(v);
    }
}
