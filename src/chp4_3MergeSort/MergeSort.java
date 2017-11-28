package chp4_3MergeSort;

import java.util.Arrays;

public class MergeSort {

	private MergeSort() {
	}

	public static <T extends Comparable<T>> void insertionSortforThis(T a[], int l, int r) {
		for (int i = l + 1; i <= r; ++i) {
			T val = a[i];
			int j;
			for (j = i; j > l && a[j - 1].compareTo(val) > 0; --j) {
				a[j] = a[j - 1];
			}
			a[j] = val;
		}
	}

	public static <T extends Comparable<T>> void merge(T[] a, int l, int mid, int r) {
		T[] c = Arrays.copyOfRange(a, l, r + 1);
		int i = l, j = mid + 1;

		for (int k = l; k <= r; ++k) {
			if (i > mid) {
				a[k] = c[j - l];
				j++;
			} else if (j > r) {
				a[k] = c[i - l];
				i++;
			} else if (c[i - l].compareTo(c[j - l]) < 0) {
				a[k] = c[i - l];
				i++;
			} else {
				a[k] = c[j - l];
				j++;
			}
		}
	}

	public static <T extends Comparable<T>> void mergeSort(T[] a, int l, int r, int depth) {

		System.out.print(repeatCharacters('-', depth * 2));
		System.out.println("Deal with [ " + l + " , " + r + "]");

		if (r - l <= 15) {
			insertionSortforThis(a, l, r);
			return;
		}

		int mid = (l + r) / 2;
		mergeSort(a, l, mid, depth + 1);
		mergeSort(a, mid + 1, r, depth + 1);
		if (a[mid].compareTo(a[mid + 1]) > 0) {
			merge(a, l, mid, r);
		}
	}

	private static String repeatCharacters(char character, int length) {
		StringBuilder s = new StringBuilder(length);
		for (int i = 0; i < length; ++i) {
			s.append(character);
			s.append(' ');
		}
		return s.toString();
	}

	public static <T extends Comparable<T>> void sort(T[] a) {

		int n = a.length - 1;
		mergeSort(a, 0, n, 0);
	}

	public static void main(String[] args) {

		Integer[] arr = new Integer[100];
		for (int i = 0; i < 100; i++) {
			arr[i] = new Integer(100 - i);
		}
		MergeSort.sort(arr);
	}
}
