package com.androidgames.glbasics;

import java.util.Random;

public class Bob {
	static final Random rand = new Random();
	public float x, y;
	float dirX, dirY;
	
	public Bob() {
		x = rand.nextFloat() * 480;
		y = rand.nextFloat() * 800;
		dirX = 100;
		dirY = 100;
	}
	
	public void update(float deltaTime) {
		x = x + dirX * deltaTime;
		y = y + dirY * deltaTime;
		
		if (x < 0) {
			dirX = -dirX;
			x = 0;
		}
		
		if (x > 480) {
			dirX = -dirX;
			x = 480;
		}
		
		if (y < 0) {
			dirY = -dirY;
			y = 0;
		}
		
		if (y > 800) {
			dirY = -dirY;
			y = 800;
		}
	}
}
