package com.example.testgame;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import com.example.testgame.object.Ball;

import android.opengl.GLSurfaceView.Renderer;
import android.util.Log;
import android.view.View;

public class testRenderer implements Renderer {
	
	private Ball ball 						= null;
	
	private static final String	TAG_NAME 	= "testRenderer";
	
	private float rotateY = 0;
	
	public testRenderer(){
		ball = new Ball();
		ball.setColor( 1, 1, 1 );
		
	}

	@Override
	public void onDrawFrame(GL10 gl) {
		// TODO Auto-generated method stub
		gl.glClear( GL10.GL_COLOR_BUFFER_BIT );
		gl.glLoadIdentity();
		
		ball.draw( gl );
		
		
		gl.glRotatef(0, 0, ( rotateY += 10), 0);
		
		if( rotateY >= 360) rotateY = 0;
	}

	@Override
	public void onSurfaceChanged(GL10 gl, int width, int height) {
		// TODO Auto-generated method stub
		if( height == 0 ){
			height = 1;
		}
		
		gl.glViewport(0, 0, width, height);
		gl.glMatrixMode( GL10.GL_PROJECTION );
		gl.glLoadIdentity();
		
		gl.glMatrixMode( GL10.GL_MODELVIEW );
		gl.glLoadIdentity();
	}

	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		// TODO Auto-generated method stub
		gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
		gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST);
		
	}


}
