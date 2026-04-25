package src;

public class Queue {
    private final int[] data;
    private int head, tail, count;
    private final int maxSize;

    public Queue(int maxSize) {
        this.maxSize = maxSize;
        this.data = new int[maxSize];
        this.head = 0;
        this.tail = 0;
        this.count = 0;
    }

    public boolean enqueue(int value) {
        if (count >= maxSize) return false;
        data[tail] = value;
        tail = (tail + 1) % maxSize;
        count++;
        return true;
    }

    public int dequeue() {
        if (count == 0) throw new IllegalStateException("fila vazia");
        int val = data[head];
        head = (head + 1) % maxSize;
        count--;
        return val;
    }

    public int peek() {
        if (count == 0) throw new IllegalStateException("fila vazia");
        return data[head];
    }

    public int size() { return count; }
    public boolean isEmpty() { return count == 0; }
    public boolean isFull() { return count == maxSize; }
    public void clear() { head = 0; tail = 0; count = 0; }
}
