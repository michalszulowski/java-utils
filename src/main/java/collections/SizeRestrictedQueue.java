package collections;

import java.util.ArrayDeque;

/**
 * Queue restricting its size. If queue is full, the element at the opposite end of the queue will be removed.
 */
public class SizeRestrictedQueue<E> extends ArrayDeque<E> {
    private int length;

    public SizeRestrictedQueue(int length) {
        super(length);
        this.length = length;
    }

    @Override
    public void addFirst(E elem) {
        if (isFull()) {
            super.removeLast();
        }
        super.addFirst(elem);
    }

    public void addLast(E elem) {
        if (isFull()) {
            super.removeFirst();
        }
        super.addLast(elem);
    }

    public boolean isFull() {
        return length == super.size();
    }
}
