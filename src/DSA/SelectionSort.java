package DSA;

public class SelectionSort {
	int[] a;

	SelectionSort(int[] a) {
		this.a = a;
	}

	public int[] selectionSort() {
		for (int i = 0; i < a.length; i++) {
			int min = i;
			for (int j = i; j < a.length; j++) {
				if (a[j] < a[min])
					min = j;
			}
			swap(i, min);
		}
		return a;
	}

	public void swap(int first, int second) {
		int temp = a[first];
		a[first] = a[second];
		a[second] = temp;
	}

	public int[] getA() {
		return a;
	}

	public void setA(int[] a) {
		this.a = a;
	}
}
