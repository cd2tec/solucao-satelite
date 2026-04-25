package src;

public class Stack {
    private final int[] data;
    private int top;
    private final int maxSize;

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        this.data = new int[maxSize];
        this.top = 0;
    }

    public boolean push(int value) {
        if (top >= maxSize) return false;
        data[top++] = value;
        return true;
    }

    public int pop() {
        if (top == 0) throw new IllegalStateException("stack underflow");
        return data[--top];
    }

    public int peek() {
        if (top == 0) throw new IllegalStateException("stack vazia");
        return data[top - 1];
    }

    public int size() { return top; }
    public boolean isEmpty() { return top == 0; }
    public boolean isFull() { return top == maxSize; }
    public void clear() { top = 0; }
}
