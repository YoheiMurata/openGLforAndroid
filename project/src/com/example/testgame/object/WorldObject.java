package com.example.testgame.object;


/*
 * WorldObject.java
 * �Q�[�����̃I�u�W�F�N�g�̒�`
 */
public class WorldObject {

	//���̐��E�ł̃I�u�W�F�N�g�̎��d��
	public static final double g 	= 9.8;
	//�d�͂����������Ȃ���
	private boolean isFallable;
	//�����W��
	private double bound;
	
	//�I�u�W�F�N�g�̏ꏊ
	private double posX;
	private double posY;
	private double posZ;
	
	//�R���X�g���N�^
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
