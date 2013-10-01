package com.example.testgame.object;


/*
 * WorldObject.java
 * ゲーム内のオブジェクトの定義
 */
public class WorldObject {

	//この世界でのオブジェクトの持つ重力
	public static final double g 	= 9.8;
	//重力を持つか持たないか
	private boolean isFallable;
	//反発係数
	private double bound;
	//摩擦係数
	private double friction;
	
	//オブジェクトの場所
	private double posX;
	private double posY;
	private double posZ;
	
	//オブジェクトの持つ速度
	private double vx;
	private double vy;
	private double vz;
	
	//コンストラクタ
	public WorldObject(){
		setFallable( false );
		setBound( 0 );
		setPosition( 0, 0, 0 );
		setFriction( 0 );
	}
	
	public boolean getFallable(){
		return isFallable;
	}
	
	public void setFallable( boolean input ){
		isFallable = input;
	}
	
	public double getFriction(){
		return friction;
	}
	
	public void setFriction( double f ){
		friction = f;
	}
	
	public double getVx(){
		return vx;
	}
	
	public double getVy(){
		return vy;
	}
	
	public double getVz(){
		return vz;
	}
	
	public void setVx( double x ){
		vx = x;
	}
	
	public void setVy( double y ){
		vy = y;
	}
	
	public void setVz( double z ){
		vz = z;
	}
	
	public void setVelocity( double x, double y, double z ){
		vx = x;
		vy = y;
		vz = z;
	}
	
	public double getBound(){
		return bound;
	}
	
	public void setBound( double input ){
		bound = input;
	}
	
	public double getPosX(){
		return posX;
	}
	
	public double getPosY(){
		return posY;
	}
	
	public double getPosZ(){
		return posZ;
	}
	
	public void setPosX( double x ){
		posX = x;
	}
	
	public void setPosY( double y ){
		posY = y;
	}
	
	public void setPosZ( double z ){
		posZ = z;
	}
	
	public void setPosition( double x, double y, double z ){
		posX = x;
		posY = y;
		posZ = z;
	}
}
