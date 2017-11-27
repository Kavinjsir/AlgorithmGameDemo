package chp3GetPIByMonteCarlomethod;

import java.awt.EventQueue;
import java.awt.Point;

public class AlgoVisualizer {

	private static int DELAY = 40;
	private MonteCarloPiData data;
	private AlgoFrame frame;
	private int N;

	public AlgoVisualizer(int sceneWidth, int sceneHeight, int N) {

		if (sceneWidth != sceneHeight) {
			throw new IllegalArgumentException("This demo must be run in a square.");
		}
		// TODO: initialize data
		this.N = N;
		Circle circle = new Circle(sceneWidth / 2, sceneHeight / 2, sceneWidth / 2);
		data = new MonteCarloPiData(circle);

		// initialize scene
		EventQueue.invokeLater(() -> {
			frame = new AlgoFrame("Get PI with Monte Carlo", sceneWidth, sceneHeight);
			new Thread(() -> {
				run();
			}).start();
		});
	}

	private void run() {

		// TODO
		for (int i = 0; i < N; ++i) {
			if (i % 100 == 0) {
				frame.render(data);
				AlgoVisHelper.pause(DELAY);
				System.out.println(data.estimatePi());
			}

			int x = (int) (Math.random() * frame.getCanvasWidth());
			int y = (int) (Math.random() * frame.getCanvasHeight());
			data.addPoint(new Point(x, y));
		}
	}

	public static void main(String[] args) {

		int sceneWidth = 800;
		int sceneHeight = 800;
		int N = 50000;

		AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth, sceneHeight, 10000);

	}
}
