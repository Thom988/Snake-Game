package com.snakegame.view;
import java.awt.Graphics;

import com.snakegame.controller.GameController;
import com.snakegame.model.GameEvaluator;

public interface GameViewable {

	
	public void paintComponent(Graphics g);
	
	public void draw(Graphics g);

	public void gameOver(Graphics g);
	
	public void setController(GameController controller);
	
	public void useRepaint();
	
	public void promptForNewApple(int x, int y);
	
	public void promptForSnakeCoordinates(int[] a, int[] b, int bodyParts);
	
	//public void setBodyParts(int bodyParts);
}
