package guimodel;

import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AlgoVisualizer {

	private Object data;
	private AlgoFrame frame;

	public AlgoVisualizer(int sceneWidth, int sceneHeight, int N) {

		// TODO: initialize data

		
		//initialize scene
		EventQueue.invokeLater(() -> {
			frame = new AlgoFrame("Welcome", sceneWidth, sceneHeight);
			// TODO: Need Mouse or Keyboard?
			frame.addKeyListener(new AlgoKeyListener());
			frame.addMouseListener(new AlgoMouseListener());
			new Thread(() -> {
				run();
			}).start();
		});
	}

	private void run() {
		
		//TODO
		
	}

	private class AlgoKeyListener extends KeyAdapter {
		
	}

	private class AlgoMouseListener extends MouseAdapter {
		
	}

	public static void main(String[] args) {

		int sceneWidth = 800;
		int sceneHeight = 800;
		int N = 10;

		AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth, sceneHeight, N);

	}
}
