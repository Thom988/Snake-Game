package com.snakegame.model;

import java.util.Random;

import com.snakegame.controller.MyKeyAdapter;

public class GameEvaluator {
	
	private int bodyParts = 6;
	public int x[] = new int[100];
	public int y[] = new int[100];
	int appleEaten;
	public int appleX;
	public int appleY;
	char direction = 'R';
	Random random;
	protected final int SCREEN_WIDTH;
	protected final int SCREEN_HEIGHT;
	protected final int UNIT_SIZE;
	
	public GameEvaluator(int screenWidth, int screenHeight, int unitSize) {
		this.SCREEN_WIDTH = screenWidth;
		this.SCREEN_HEIGHT = screenHeight;
		this.UNIT_SIZE = unitSize;
	}
	

	public void move() {
		for(int i = bodyParts; i>0; i--) {
			x[i]= x[i-1];
			y[i]= y[i-1];
		}
		switch(MyKeyAdapter.getDirection()) {
		case 'U':
			y[0] = y[0]-UNIT_SIZE;
		break;
		case 'D':
			y[0] = y[0]+UNIT_SIZE;
		break;
		case 'L':
			x[0] = x[0]-UNIT_SIZE;
		break;
		case 'R':
			x[0] = x[0]+UNIT_SIZE;
		break;
		}
	}
	
	
	public void newApple() {
		Random random = new Random();
		appleX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
		appleY = random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE;
	}
	
	public boolean checkCollisions() {
		for (int i = 1; i < (bodyParts-1) ; i++) {
			if ((x[0] == x[i]) && (y[0] == y[i])) {
				return true;
			}
		}
		//check if head touches left border
		if (x[0] < 0) {
			return true;
		}
		//check if head touches right border
		else if (x[0] > SCREEN_WIDTH) {
			return true;
		}
		//check if head touches top border
		else if (y[0] < 0) {
			return true;
		}
		//check if head touches bottom border
		else if (y[0] > SCREEN_HEIGHT) {
			return true;
		} else {
			return false;
		}
	}
		
	public boolean checkApple() {
		if ((x[0] == appleX) && (y[0] == appleY)) {
			bodyParts++;
			appleEaten++;
			return true;
		}
		return false;
	}


	public int getBodyParts() {
		return bodyParts;
	}

}
