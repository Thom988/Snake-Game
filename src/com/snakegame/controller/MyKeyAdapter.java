package com.snakegame.controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MyKeyAdapter extends KeyAdapter{
	
	static char direction = 'R';
	
	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_LEFT :
			if(direction != 'R') {
				direction = 'L';
			}
		break;
		case KeyEvent.VK_RIGHT :
			if(direction != 'L') {
				direction = 'R';
			}
		break;
		case KeyEvent.VK_UP :
			if(direction != 'D') {
				direction = 'U';
			}
		break;
		case KeyEvent.VK_DOWN :
			if(direction != 'U') {
				direction = 'D';
			}
		break;
		}
	}

	public static char getDirection() {
		return direction;
	}
	
	
		
}
