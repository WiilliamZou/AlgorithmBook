import edu.princeton.cs.algs4.Queue;

/**
 * Created by yunxiaozou on 3/18/16.
 */
public class SequentialSearchST<Key, Value> {
    private Node first;

    public Value get(Key key) {
        for (Node x = first; x != null; x = x.next)
            if (key.equals(x.key))
                return x.val;
        return null;
    }

    public void put(Key key, Value val) {
        for (Node x = first; x != null; x = x.next)
            if (key.equals(x.key)) {
                x.val  = val;
                return;
            }
        first = new Node(key, val, first);
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (Node x = first; x != null; x = x.next){
            queue.enqueue(x.key);
        }
        return queue;
    }

    private class Node {
        Key key;
        Value val;
        Node next;
        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }


    }
}
