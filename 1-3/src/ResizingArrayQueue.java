import java.util.Iterator;

/**
 * Created by yunxiaozou on 4/12/16.
 */
public class ResizingArrayQueue<Item> {
    private int front = -1;
    private int rear = -1;
    Item[] array = (Item[] )new Object[1];
    int N = 0;
    public boolean isEmpty() {return N == 0;}
    public int size() {return N;}

    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        int i;
        for (i = 0; i < N; i++) {
            temp[i] = array[front+1+i];
        }
        front = -1;
        rear = i;
        array = temp;
    }

    public void enqueue(Item item) {
        if (N == array.length) resize(2 * array.length);
        array[(++rear)%array.length] = item;
        N++;
    }

    public Item pop() {
        if (N == 0) return null;
        Item item = array[(++front) % array.length];
        N--;
        if (N > 0 && N <= array.length/4) resize(array.length/2);
        return item;
    }

    public Iterator<Item> iterator() {
        return new QueueArrayIterator();
    }
    public class QueueArrayIterator implements Iterator<Item> {
        private int start = front + 1;
        private int count = 0;
        public  boolean hasNext() {return count < N;};
        public Item next() {
            return array[start + (count++)];
        }
    }

}
