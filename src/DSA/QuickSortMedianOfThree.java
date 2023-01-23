package DSA;

public class QuickSortMedianOfThree {
    long[] theArray;
    int nElems;

    QuickSortMedianOfThree(long[] theArray) {
        this.theArray = theArray;
        nElems = theArray.length;
    }

    public void quickSort() {
        quickSort(0, nElems - 1);
    }

    public void manualSort(int left, int right) {
        int size = right - left + 1;
        if (size <= 1)
            return;
        if (size == 2) {
            if (theArray[left] > theArray[right])
                swap(left, right);
            return;
        } else {
            if (theArray[left] > theArray[right - 1])
                swap(left, right - 1);
            if (theArray[left] > theArray[right])
                swap(left, right);
            if (theArray[right - 1] > theArray[right])
                swap(right - 1, right);
        }
    }

    public long medainOf3(int left, int right) {
        int center = (left + right) / 2;

        if (theArray[left] > theArray[center])
            swap(left, center);

        if (theArray[left] > theArray[right])
            swap(left, right);

        if (theArray[center] > theArray[right])
            swap(center, right);

        swap(center, right - 1);
        return theArray[right - 1];
    }

    public void swap(int leftPos, int rightPos) {
        long temp = theArray[leftPos];
        theArray[leftPos] = theArray[rightPos];
        theArray[rightPos] = temp;
    }

    public int partitionIt(int left, int right, long pivot) {
        int leftPtr = left;
        int rightPtr = right - 1;

        while (true) {
            while (theArray[++leftPtr] < pivot)
                ;
            while (theArray[--rightPtr] > pivot)
                ;

            if (leftPtr >= rightPtr)
                break;
            else
                swap(leftPtr, rightPtr);
        }
        swap(leftPtr, right - 1);
        return leftPtr;
    }

    public void quickSort(int left, int right) {
        int size = right - left + 1;
        if (size <= 3)
            manualSort(left, right);
        else {
            long median = medainOf3(left, right);
            int partition = partitionIt(left, right, median);
            quickSort(left, partition - 1);
            quickSort(partition + 1, right);
        }
    }
}
