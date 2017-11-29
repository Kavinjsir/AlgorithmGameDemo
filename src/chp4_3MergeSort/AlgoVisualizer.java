package chp4_3MergeSort;

import java.awt.EventQueue;
import java.util.Arrays;

public class AlgoVisualizer {

	private static int DELAY = 60;
	private MergeSortData data;
	private AlgoFrame frame;

	public AlgoVisualizer(int sceneWidth, int sceneHeight, int N) {

		// TODO: initialize data
		data = new MergeSortData(N, sceneHeight);

		// initialize scene
		EventQueue.invokeLater(() -> {
			frame = new AlgoFrame("Selection Sort Visualization", sceneWidth, sceneHeight);
			new Thread(() -> {
				run();
			}).start();
		});
	}

	private void run() {
		setData(-1, -1, -1);
		int len = data.N();
		// Top->Bottom:
		mergeSort(0, len - 1);

		// Bottom->Top:
		/*
		for (int sz = 1; sz < len; sz *= 2) {
			for (int i = 0; i < len - sz; i += sz + sz) {
				merge(i, i + sz - 1, Math.min(i + sz + sz - 1, len - 1));
			}
		}
		*/

		setData(0, len - 1, len - 1);
	}

	private void mergeSort(int l, int r) {
		if (l >= r) {
			return;
		}

		setData(l, r, -1);

		int mid = (l + r) / 2;
		mergeSort(l, mid);
		mergeSort(mid + 1, r);
		merge(l, mid, r);
	}

	private void merge(int l, int mid, int r) {
		int[] aux = Arrays.copyOfRange(data.numbers, l, r + 1);
		int i = l, j = mid + 1;
		for (int k = l; k <= r; k++) {

			if (i > mid) {
				data.numbers[k] = aux[j - l];
				j++;
			} else if (j > r) {
				data.numbers[k] = aux[i - l];
				i++;
			} else if (aux[i - l] < aux[j - l]) {
				data.numbers[k] = aux[i - l];
				i++;
			} else {
				data.numbers[k] = aux[j - l];
				j++;
			}
			setData(l, r, k);
		}
	}

	private void setData(int l, int r, int mergeIndex) {
		data.l = l;
		data.r = r;
		data.mergeIndex = mergeIndex;

		frame.render(data);
		AlgoVisHelper.pause(DELAY);
	}

	public static void main(String[] args) {

		int sceneWidth = 800;
		int sceneHeight = 800;
		int N = 100;

		AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth, sceneHeight, N);

	}
}
