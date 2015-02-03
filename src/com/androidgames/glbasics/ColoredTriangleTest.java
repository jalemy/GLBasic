package com.androidgames.glbasics;

import com.androidgames.framework.Screen;
import com.androidgames.framework.impl.GLGame;

public class ColoredTriangleTest extends GLGame {
	@Override
	public Screen getStartScreen() {
		return new ColoredTriangleScreen(this);
	}
}
