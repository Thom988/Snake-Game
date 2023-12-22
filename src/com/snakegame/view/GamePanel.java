package com.snakegame.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.snakegame.controller.GameController;
import com.snakegame.controller.MyKeyAdapter;
import com.snakegame.model.GameEvaluator;

public class GamePanel extends JPanel implements GameViewable {
	
	public final int SCREEN_WIDTH = 600;
	public final int SCREEN_HEIGHT = 600;
	public final int UNIT_SIZE = 100;
	GameController controller;
	MyKeyAdapter myKey;
	private int x[] = new int[100];
	private int y[] = new int[100];
	private int appleX;
	private int appleY;
	private int appleEaten = -1;
	private int bodyParts = 6;
	
	
	
	public GamePanel() {

		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		this.setBackground(Color.BLACK);
		this.setFocusable(true);
		this.addKeyListener(new MyKeyAdapter());
	}
	
	public void setController(GameController controller) {
		this.controller = controller;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}
	
	public void draw(Graphics g) {
		if (controller.isRunning()) {
			for (int i = 0; i < SCREEN_HEIGHT/UNIT_SIZE; i++) {
				g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, SCREEN_HEIGHT);
				g.drawLine(0, i*UNIT_SIZE, SCREEN_WIDTH, i*UNIT_SIZE);
			}
			g.setColor(Color.RED);
			g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);
			for (int i = 0;i<bodyParts; i++) {
				if (i == 0) {
					g.setColor(Color.GREEN);
					g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
				} else {
					g.setColor(new Color(45,180,0));
					g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
				}
			}
			g.setColor(Color.RED);
			g.setFont(new Font("Ink Free", Font.BOLD, 40));
			FontMetrics metrics = getFontMetrics(g.getFont());
			g.drawString("Score: "+ appleEaten,  (SCREEN_WIDTH - metrics.stringWidth("Score: "+ appleEaten))/2, g.getFont().getSize());
		} else {
			gameOver(g);
		}
	}

	
	public void gameOver(Graphics g) {
		// score 
		g.setColor(Color.RED);
		g.setFont(new Font("Ink Free", Font.BOLD, 40));
		FontMetrics metrics1 = getFontMetrics(g.getFont());
		g.drawString("Score: "+ appleEaten,  (SCREEN_WIDTH - metrics1.stringWidth("Score: "+ appleEaten))/2, g.getFont().getSize());
		g.setColor(Color.RED);
		g.setFont(new Font("Ink Free", Font.BOLD, 75));
		FontMetrics metrics2 = getFontMetrics(g.getFont());
		g.drawString("Game Over",  (SCREEN_WIDTH - metrics2.stringWidth("Game Over"))/2, SCREEN_HEIGHT/2);
	}
	
	public void promptForNewApple(int x, int y){
		appleX = x;
		appleY = y;
		appleEaten ++;
	}

	@Override
	public void useRepaint() {
		repaint();
	}
	
	public void promptForSnakeCoordinates(int[] x, int[] y, int bodyParts) {
		for (int i = 0; i<bodyParts; i++) {
			this.x[i]= x[i];
			this.y[i]= y[i];
			this.bodyParts = bodyParts;
		}
	}
	
}
