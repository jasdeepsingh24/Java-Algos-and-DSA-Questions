package DSA;

public class Main {
	public static void main(String[] args) {
		int[] a = { 4, 5, 6, 2, 9, 0, 5, 2, 1 };
		InsertionSort s = new InsertionSort(a);

		a = s.insertionSort();

		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");

	}
}
