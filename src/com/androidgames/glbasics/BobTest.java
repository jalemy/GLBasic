package com.androidgames.glbasics;

import javax.microedition.khronos.opengles.GL10;

import com.androidgames.framework.Game;
import com.androidgames.framework.Screen;
import com.androidgames.framework.gl.FPSCounter;
import com.androidgames.framework.gl.Texture;
import com.androidgames.framework.gl.Vertices;
import com.androidgames.framework.impl.GLGame;
import com.androidgames.framework.impl.GLGraphics;

public class BobTest extends GLGame {
	
	@Override
	public Screen getStartScreen() {
		return new BobScreen(this);
	}
	
	class BobScreen extends Screen {
		static final int NUM_BOBS = 100;
		GLGraphics glGraphics;
		Texture bobTexture;
		Vertices bobModel;
		Bob[] bobs;
		FPSCounter fc = new FPSCounter();
		
		public BobScreen(Game game) {
			super(game);
			glGraphics = ((GLGame)game).getGLGraphics();
			
			bobTexture = new Texture((GLGame)game, "bobrgb888.png");
			
			bobModel = new Vertices(glGraphics, 4, 12, false, true);
			bobModel.setVertices(new float[] { -16, -16, 0, 1,
											    16, -16, 1, 1,
											    16,  16, 1, 0,
											   -16,  16, 0, 0, },
												0, 16);
			bobModel.setIndices(new short[] { 0, 1, 2, 2, 3, 0}, 0, 6);
			
			bobs = new Bob[NUM_BOBS];
			for (int i = 0; i < NUM_BOBS; i++) {
				bobs[i] = new Bob();
			}
			
			
		}

		@Override
		public void update(float deltaTime) {
			game.getInput().getTouchEvents();
			game.getInput().getKeyEvents();
			
			for (int i = 0; i < NUM_BOBS; i++) {
				bobs[i].update(deltaTime);
			}
		}

		@Override
		public void present(float deltaTime) {
			fc.logFrame();
			GL10 gl = glGraphics.getGL();
			gl.glViewport(0, 0, glGraphics.getWidth(), glGraphics.getHeight());
			gl.glClearColor(0.7f, 0.8f, 1, 1);
			gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
			gl.glMatrixMode(GL10.GL_PROJECTION);
			gl.glLoadIdentity();
			gl.glOrthof(0, 480, 0, 800, 1, -1);
			
			gl.glEnable(GL10.GL_TEXTURE_2D);
			bobTexture.bind();
			gl.glMatrixMode(GL10.GL_MODELVIEW);
			for (int i = 0; i < NUM_BOBS; i++) {
				gl.glLoadIdentity();
				gl.glTranslatef(bobs[i].x, bobs[i].y, 0);
				gl.glRotatef(45, 0, 0, 1);
				gl.glScalef(1, 2, 1);
				bobModel.draw(GL10.GL_TRIANGLES, 0, 6);
			}
		}

		@Override
		public void pause() {
			
		}

		@Override
		public void resume() {
			
		}

		@Override
		public void dispose() {
			
		}
	}
	
}
