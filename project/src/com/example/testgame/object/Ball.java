package com.example.testgame.object;

import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

public class Ball extends WorldObject {
	
	//デフォルトの半径を設定
	public static double DEFAULT_RADIUS		= 0.3;
	
	private static final double rad			= Math.PI / 180;
	
	public static float DEFAULT_COLOR_R		= 1;
	public static float DEFAULT_COLOR_G		= 1;
	public static float DEFAULT_COLOR_B		= 1;
	
	private static int NUM_VERTEX_BUF_SIZE	= 40000;
	
	//球の半径
	private double radius;

	//球の頂点リスト
	//private ArrayList<Float> vertics = new ArrayList<Float>();
	FloatBuffer sphereVertex = FloatBuffer.allocate( NUM_VERTEX_BUF_SIZE );
	
	
	public Ball(){
		setFallable( true );
		radius = DEFAULT_RADIUS;
	}
	
	public Ball( double r ){
		setFallable( true );
		radius = r;
	}
	
	public double getRadius(){
		return radius;
	}
	
	public void setRadius( double r ){
		radius = r;
	}
	
	public void draw( GL10 gl, double x, double y, double z ){
		
	}
}
