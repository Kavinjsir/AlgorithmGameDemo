package chp3AMoneyExperiment;

import java.awt.EventQueue;
import java.util.Arrays;

public class AlgoVisualizer {

	private static int DELAY = 40;
	private int[] money;
	private AlgoFrame frame;

	public AlgoVisualizer(int sceneWidth, int sceneHeight) {

		// TODO: initialize data
		money = new int[100];
		for (int i = 0; i < money.length; ++i) {
			money[i] = 100;
		}

		// initialize scene
		EventQueue.invokeLater(() -> {
			frame = new AlgoFrame("Welcome", sceneWidth, sceneHeight);
			new Thread(() -> {
				run();
			}).start();
		});
	}

	private void run() {

		// TODO
		while (true) {
			Arrays.sort(money);
			frame.render(money);
			AlgoVisHelper.pause(DELAY);

			for (int k = 0; k < 50; ++k) {
				for (int i = 0; i < money.length; ++i) {
					// if (money[i] > 0) {
					int j = (int) (Math.random() * money.length);
					money[i] -= 1;
					money[j] += 1;
					// }
				}
			}
		}
	}

	public static void main(String[] args) {

		int sceneWidth = 1000;
		int sceneHeight = 800;

		AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth, sceneHeight);

	}
}
