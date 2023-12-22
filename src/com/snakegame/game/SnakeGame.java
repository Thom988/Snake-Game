package com.snakegame.game;

import com.snakegame.controller.GameController;
import com.snakegame.model.GameEvaluator;
import com.snakegame.view.GameFrame;
import com.snakegame.view.GamePanel;

public class SnakeGame {
	
	static final int SCREEN_WIDTH = 600;
	static final int SCREEN_HEIGHT = 600;
	static final int UNIT_SIZE = 20;

	public static void main(String[] args) {
		
		GamePanel panel = new GamePanel();
		GameFrame frame = new GameFrame(panel);
		GameController gc = new GameController(panel, new GameEvaluator(panel.SCREEN_WIDTH, panel.SCREEN_HEIGHT, panel.UNIT_SIZE));
		gc.startGame();
	}

}
