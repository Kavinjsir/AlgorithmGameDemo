package com;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AlgoFrame extends JFrame {

	private int canvasWidth;
	private int canvasHeight;

	public AlgoFrame(String title, int canvasWidth, int canvasHeight) {

		super(title);

		this.canvasWidth = canvasWidth;
		this.canvasHeight = canvasHeight;

		AlgoCanvas canvas = new AlgoCanvas();

		setContentPane(canvas);
		pack();

		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setVisible(true);
	}

	public AlgoFrame(String title) {
		this(title, 1024, 768);
	}

	public int getCanvasWidth() {
		return canvasWidth;
	}

	public int getCanvasHeight() {
		return canvasHeight;
	}

	
	private Circle[] circles;
	public void render(Circle[] circles) {
		this.circles = circles;
		repaint();
	}

	private class AlgoCanvas extends JPanel {

		public AlgoCanvas() {
			super(true);
		}

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			Graphics2D g2d = (Graphics2D) g;

			// 抗锯齿
			RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
			g2d.addRenderingHints(hints);

			// drawing
			
			AlgoVisHelper.setStrokeWidth(g2d, 1);
			AlgoVisHelper.setColor(g2d, Color.RED);
			for (Circle circle : circles) {
				if (!circle.isFilled) {
					AlgoVisHelper.strokeCircle(g2d, circle.x, circle.y, circle.getR());
				} else {
					AlgoVisHelper.fillCircle(g2d, circle.x, circle.y, circle.getR());
				}
			}
			

		}

		@Override
		public Dimension getPreferredSize() {
			return new Dimension(canvasWidth, canvasHeight);
		}
	}

}
