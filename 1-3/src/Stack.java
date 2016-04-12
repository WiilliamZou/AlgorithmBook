import java.util.Iterator;

/**
 * Created by yunxiaozou on 4/12/16.
 */
public class Stack<Item> {
    private DoubleLinkedNode first;
    private DoubleLinkedNode last;
    private int N;

    private class DoubleLinkedNode {
        Item item;
        DoubleLinkedNode prev;
        DoubleLinkedNode next;
    }
    public boolean isEmpty() {return first == null;}
    public int size() {return N;}

    public void push(Item item) {
        DoubleLinkedNode oldlast = last;
        last = new DoubleLinkedNode();
        last.item = item;
        last.prev = oldlast;
        last.next = null;
        if (isEmpty()) first = last;
        else           oldlast.next = last;
        N++;
    }

    public Item pop() {
        if (isEmpty()) return null;
        Item item = last.item;
        first.next = first;
        if (isEmpty()) last = null;
        N--;
        return item;
    }

    public Iterator<Item> iterator() {
        return new ReverseListIterator();
    }

    private class ReverseListIterator implements Iterator<Item> {
        private DoubleLinkedNode current = last;
        public boolean hasNext() {
            return current != null;
        }
        public Item next() {
            Item item = current.item;
            current = current.prev;
            return item;
        }
    }
}
