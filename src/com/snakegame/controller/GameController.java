package com.snakegame.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import com.snakegame.model.GameEvaluator;
import com.snakegame.view.GameViewable;

public class GameController implements ActionListener {
	
	static final int DELAY = 75;
	private GameViewable view;
	private Timer timer;
	private GameEvaluator evaluator;
	private boolean running = false;
	
	
	public GameController(GameViewable view, GameEvaluator evaluator) {
		this.view = view;
		view.setController(this);
		this.evaluator = evaluator;
		
	}
	
	public void startGame() {
		running = true;
		timer = new Timer(DELAY,this);
		evaluator.newApple();
		view.promptForNewApple(evaluator.appleX, evaluator.appleY);
		timer.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		if (running) {
			evaluator.move();
			view.promptForSnakeCoordinates(evaluator.x, evaluator.y, evaluator.getBodyParts());
			if (evaluator.checkApple()) {
				evaluator.newApple();
				view.promptForNewApple(evaluator.appleX, evaluator.appleY);
			}
			running = !(evaluator.checkCollisions());
		}
		view.useRepaint();
	}
	
	public void timerStop() {
		timer.stop();
	}
	
	public boolean isRunning() {
		return this.running;
	}

}
