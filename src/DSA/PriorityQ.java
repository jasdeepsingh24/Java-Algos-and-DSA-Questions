package DSA;

public class PriorityQ {
    private int maxSize;
    private long[] qArray;
    private int nItems;

    PriorityQ(int maxSize) {
        this.maxSize = maxSize;
        qArray = new long[maxSize];
        nItems = 0;
    }

    public void insert(long item) {
        int j;
        if (nItems == 0)
            qArray[nItems++] = item;
        else {
            for (j = nItems - 1; j >= 0; j++) {
                if (item > qArray[j])
                    qArray[j + 1] = qArray[j];
                else
                    break;
            }
            qArray[j + 1] = item;
            nItems++;
        }
    }

    public long remove() {
        return qArray[--nItems];
    }

    public long peekMin() {
        return qArray[nItems - 1];
    }

    public boolean isEmpty() {
        return nItems == 0;
    }

    public boolean isFull() {
        return nItems == maxSize;
    }
}
