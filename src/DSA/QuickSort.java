package DSA;

public class QuickSort {
    int[] theArray;

    QuickSort(int[] theArray) {
        this.theArray = theArray;
    }

    public void quickSort() {
        quickSort(0, theArray.length - 1);
    }

    public int partition(int left, int right, int pivot) {
        int leftPtr = left - 1;
        int rightPtr = right;

        while (true) {
            while (theArray[++leftPtr] < pivot)
                ;

            while (right > 0 && theArray[--rightPtr] > pivot)
                ;

            if (left >= right)
                break;
        }
        swap(leftPtr, rightPtr);
        return leftPtr;
    }

    public void swap(int leftPos, int rightPos) {
        int temp = theArray[leftPos];
        theArray[leftPos] = theArray[rightPos];
        theArray[rightPos] = temp;
    }

    public void quickSort(int left, int right) {
        if (left - right >= 0)
            return;

        int partition = partition(left, right, theArray[right]);
    }

}
