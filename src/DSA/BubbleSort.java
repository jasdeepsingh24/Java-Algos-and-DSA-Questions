package DSA;

public class BubbleSort {
	private long[] a;
	private int nElems;

	public static void main(String[] args) {
		System.out.println("Main function starts");
	}

	public BubbleSort(int max) {
		a = new long[max];
		nElems = 0;
	}

	public void insert(long value) {
		a[nElems] = value;
		nElems++;
	}

	public void display() {
		for (int j = 0; j < nElems; j++) {
			System.out.print(a[j] + " ");
		}
		System.out.println();
	}

	public void bubbleSort() {
		int out, in;
		for (out = nElems - 1; out >= 1; out--) {
			for (in = 0; in < out; in++) {
				if (a[in] > a[in + 1])
					swap(in, in + 1);
			}
		}
	}

	public void swap(int first, int second) {
		long temp = a[first];
		a[first] = a[second];
		a[second] = temp;
	}
}
