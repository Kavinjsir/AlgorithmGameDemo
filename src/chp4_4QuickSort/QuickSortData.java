package chp4_4QuickSort;

public class QuickSortData {

	public int[] numbers;
	public int l, r;
	public int curPivot, curElement;
	public boolean[] fixedPivots;

	public QuickSortData(int N, int randomBound) {
		numbers = new int[N];
		fixedPivots = new boolean[N];
		for (int i = 0; i < numbers.length; ++i) {
			numbers[i] = (int) (Math.random() * randomBound) + 1;
			fixedPivots[i] = false;
		}
	}

	public int N() {
		return numbers.length;
	}

	public int get(int index) {
		if (index < 0 || index >= numbers.length) {
			throw new IllegalArgumentException("Invalid index to access Sort Data.");
		}
		return numbers[index];
	}

	public void swap(int i, int j) {
		int t = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = t;
	}
}
