package com.example.testgame;

import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class TestGame extends Activity {
	
	private GLSurfaceView 	view 		= null;
	private testRenderer	renderer 	= null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test_game);
		
		view = new GLSurfaceView( this );
		renderer = new testRenderer();
		
		view.setRenderer( renderer );
		
		
		setContentView( view );
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.test_game, menu);
		return true;
	}

}
