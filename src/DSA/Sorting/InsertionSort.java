package DSA;

public class InsertionSort {
	int[] a;

	InsertionSort(int[] a) {
		this.a = a;
	}

	public int[] insertionSort() {
		for (int i = 1; i < a.length; i++) {
			int marked = a[i];
			while (i > 0 && a[i - 1] >= marked) {
				a[i] = a[i - 1];
				--i;
			}
			a[i] = marked;
		}
		return a;
	}
}
