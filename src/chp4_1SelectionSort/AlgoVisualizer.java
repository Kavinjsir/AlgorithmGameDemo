package chp4_1SelectionSort;

import java.awt.EventQueue;

public class AlgoVisualizer {

	private static int DELAY = 1;
	private SelectionSortData data;
	private AlgoFrame frame;

	public AlgoVisualizer(int sceneWidth, int sceneHeight, int N) {

		// TODO: initialize data
		data = new SelectionSortData(N, sceneHeight);

		// initialize scene
		EventQueue.invokeLater(() -> {
			frame = new AlgoFrame("Selection Sort Visualization", sceneWidth, sceneHeight);
			new Thread(() -> {
				run();
			}).start();
		});
	}

	private void run() {

		setData(0, -1, -1);

		for (int i = 0; i < data.N(); ++i) {
			int minIndex = i;
			setData(i, -1, minIndex);
			for (int j = i + 1; j < data.N(); j++) {
				setData(i, j, minIndex);
				if (data.get(j) < data.get(minIndex)) {
					minIndex = j;
					setData(i, j, minIndex);
				}
			}
			data.swap(minIndex, i);
			setData(i + 1, -1, -1);
		}

		setData(data.N(), -1, -1);
	}

	private void setData(int orderedIndex, int currentCompareIndex, int currentMinIndex) {
		data.orderedIndex = orderedIndex;
		data.currentCompareIndex = currentCompareIndex;
		data.currentMinIndex = currentMinIndex;

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
