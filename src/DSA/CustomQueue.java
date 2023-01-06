package DSA;

public class CustomQueue {
    private int maxSize;
    private long[] qArray;
    private int front;
    private int rear;
    private int nItems;

    public CustomQueue(int maxSize) {
        this.maxSize = maxSize;
        this.qArray = new long[maxSize];
        this.front = 0;
        this.rear = -1;
        this.nItems = 0;
    }

    public void insert(long item) {
        if (rear == maxSize - 1)
            rear = -1;
        qArray[++rear] = item;
        nItems++;
    }

    public long remove() {
        long temp = qArray[front++];
        if (front == maxSize)
            front = 0;
        nItems--;
        return temp;
    }

    public long peekFront() {
        return qArray[front];
    }

    public boolean isEmpty() {
        return nItems == 0;
    }

    public boolean isFull() {
        return nItems == maxSize;
    }

    public int size() {
        return nItems;
    }
}
