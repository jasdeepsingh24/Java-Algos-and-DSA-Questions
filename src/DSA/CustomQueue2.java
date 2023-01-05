package DSA;

public class CustomQueue2 {
    private int maxSize;
    private long[] qArray;
    private int front;
    private int rear;

    public CustomQueue2(int maxSize) {
        this.maxSize = maxSize + 1;
        qArray = new long[maxSize];
        front = 0;
        rear = -1;
    }

    public void insert(long item) {
        if (rear == maxSize - 1)
            rear = -1;
        qArray[++rear] = item;
    }

    public long remove() {
        long temp = qArray[front++];
        if (front == maxSize)
            front = 0;
        return temp;
    }

    public long peek() {
        return qArray[front];
    }

    public boolean isEmpty() {
        return (rear + 1 == front || (front + maxSize - 1 == rear));
    }

    public boolean isFull() {
        return (rear + 2 == front || (front + maxSize - 2 == rear));
    }

    public int size() {
        if (rear >= front)
            return rear - front + 1;
        else
            return (maxSize - front) + (rear - 1);
    }
}
