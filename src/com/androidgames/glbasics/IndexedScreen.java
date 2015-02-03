package com.androidgames.glbasics;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

import com.androidgames.framework.Game;
import com.androidgames.framework.Screen;
import com.androidgames.framework.gl.Texture;
import com.androidgames.framework.impl.GLGame;
import com.androidgames.framework.impl.GLGraphics;

public class IndexedScreen extends Screen {
	final int VERTEX_SIZE = (2 + 2) * 4;
	GLGraphics glGraphics;
	FloatBuffer vertices;
	ShortBuffer indices;
	Texture texture;
	
	public IndexedScreen(Game game) {
		super(game);
		glGraphics = ((GLGame)game).getGLGraphics();
		
		ByteBuffer byteBuffer = ByteBuffer.allocateDirect(4 * VERTEX_SIZE);
		byteBuffer.order(ByteOrder.nativeOrder());
		vertices = byteBuffer.asFloatBuffer();
		vertices.put(new float[] { 100.0f, 100.0f, 0.0f, 1.0f,
								   228.0f, 100.0f, 1.0f, 1.0f,
								   228.0f, 228.0f, 1.0f, 0.0f,
								   100.0f, 228.0f, 0.0f, 0.0f
		});
		vertices.flip();
		
		byteBuffer = ByteBuffer.allocateDirect(6 * 2);
		byteBuffer.order(ByteOrder.nativeOrder());
		indices = byteBuffer.asShortBuffer();
		indices.put(new short[] { 0, 1, 2,
				                  2, 3, 0
		});
		indices.flip();
		
		texture = new Texture((GLGame)game, "bobrgb888.png");
	}


	@Override
	public void update(float deltaTime) {
		game.getInput().getTouchEvents();
		game.getInput().getKeyEvents();
	}


	@Override
	public void present(float deltaTime) {
		GL10 gl = glGraphics.getGL();
		gl.glViewport(0, 0, glGraphics.getWidth(), glGraphics.getHeight());
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		gl.glMatrixMode(GL10.GL_PROJECTION);
		gl.glLoadIdentity();
		gl.glOrthof(0, 480, 0, 800, 1, -1);
		
		gl.glEnable(GL10.GL_TEXTURE_2D);
		texture.bind();
		
		gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		
		vertices.position(0);
		gl.glVertexPointer(2, GL10.GL_FLOAT, VERTEX_SIZE, vertices);
		vertices.position(2);
		gl.glTexCoordPointer(2, GL10.GL_FLOAT, VERTEX_SIZE, vertices);
		
		gl.glDrawElements(GL10.GL_TRIANGLES, 6, GL10.GL_UNSIGNED_SHORT, indices);
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
