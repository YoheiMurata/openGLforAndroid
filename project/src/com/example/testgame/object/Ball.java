package com.example.testgame.object;

public class Ball extends WorldObject {
	
	//�f�t�H���g�̔��a��ݒ�
	public static double DEFAULT_RADIOUS 	= 0.3;
	private double radious;

	public Ball(){
		setFallable( true );
		radious = DEFAULT_RADIOUS;
		
	}
	
	public Ball( double r ){
		setFallable( true );
		radious = r;
	}
	
	
}
