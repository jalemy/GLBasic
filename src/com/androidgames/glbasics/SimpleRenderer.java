package com.androidgames.glbasics;

import java.util.Random;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLSurfaceView.Renderer;
import android.util.Log;

public class SimpleRenderer implements Renderer {
	Random rand = new Random();
	
	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		Log.d("GLSurfaceViewTest", "surface created");
	}
	
	@Override
	public void onDrawFrame(GL10 gl) {
		gl.glClearColor(rand.nextFloat(), rand.nextFloat(), rand.nextFloat(), 1);
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
	}

	@Override
	public void onSurfaceChanged(GL10 gl, int width, int height) {
		Log.d("GLSurfaceViewTest", "surface changed: " + width + "x" + height);
	}

}
