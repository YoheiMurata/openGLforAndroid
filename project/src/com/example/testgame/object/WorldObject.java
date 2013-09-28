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
	
	//オブジェクトの場所
	private double posX;
	private double posY;
	private double posZ;
	
	//コンストラクタ
	public WorldObject(){
		isFallable 	= true;
		bound 		= 0.0; 
	}
	
	public boolean getFallable(){
		return isFallable;
	}
	
	public void setFallable( boolean input ){
		isFallable = input;
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
