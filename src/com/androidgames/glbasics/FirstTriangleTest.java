package com.androidgames.glbasics;

import com.androidgames.framework.Screen;
import com.androidgames.framework.impl.GLGame;

public class FirstTriangleTest extends GLGame {
	@Override
	public Screen getStartScreen() {
		return new FirstTriangleScreen(this);
	}
}
