package com.androidgames.glbasics;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class GLSurfaceViewTest extends Activity {
	GLSurfaceView glView;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
					         WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		glView = new GLSurfaceView(this);
		glView.setRenderer(new SimpleRenderer());
		setContentView(glView);
	}
	
	@Override
	public void onResume() {
		super.onResume();
		glView.onResume();
	}
	
	@Override
	public void onPause() {
		super.onPause();
		glView.onPause();
	}

}
