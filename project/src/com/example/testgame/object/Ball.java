package com.example.testgame.object;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
//import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

import android.util.Log;

public class Ball extends WorldObject {
	
	private static final String TAG_NAME 			= "Ball";
	//�f�t�H���g�̔��a��ݒ�
	public static final double DEFAULT_RADIUS		= 0.3;
	//�f�t�H���g�̒��_�Ԃ̉𑜓x
	public static final double DEFAULT_STEPS		= 25;
	
	private static final double rad					= Math.PI / 180;
	
	public static float DEFAULT_COLOR_R				= 1;
	public static float DEFAULT_COLOR_G				= 1;
	public static float DEFAULT_COLOR_B				= 1;
	
	private float color_r 							= DEFAULT_COLOR_R;
	private float color_g							= DEFAULT_COLOR_G;
	private float color_b							= DEFAULT_COLOR_B;
	
	private static int NUM_VERTEX_BUF_SIZE			= 400000;
	private static int NUM_VERTEX					= NUM_VERTEX_BUF_SIZE / 4;
	
	//���̔��a
	private double radius							= DEFAULT_RADIUS;
	//���̒��_�Ԃ̉𑜓x�������w�W�i�E�E�E���Ǝv���j
	private double mStep							= DEFAULT_STEPS;
	//���̒��_��
	private int mPoints								= 0;

	//���̒��_���X�g
	private float[] vertics = new float[ NUM_VERTEX ];
	//private ArrayList<Float> vertics = new ArrayList<Float>();
	//FloatBuffer sphereVertex = FloatBuffer.allocate( NUM_VERTEX_BUF_SIZE );
	ByteBuffer sphereVertex = ByteBuffer.allocateDirect( NUM_VERTEX_BUF_SIZE );
	
	public Ball(){
		super();
		radius = DEFAULT_RADIUS;
	}
	
	public Ball( double r ){
		super();
		radius = r;
	}
	
	public double getStep(){
		return mStep;
	}
	
	public void setStep( double s ){
		mStep = s;
	}
	
	public double getRadius(){
		return radius;
	}
	
	public void setRadius( double r ){
		radius = r;
	}
	
	public float getR(){
		return color_r;
	}
	
	public float getG(){
		return color_g;
	}
	
	public float getB(){
		return color_b;
	}
	
	public void setColor( float r, float g, float b ){
		color_r = r;
		color_g = g;
		color_b = b;
	}
	
	public void draw( GL10 gl ){
		mPoints = buid( getPosX(), getPosY(), getPosZ() );
		
//		Log.v(TAG_NAME, "mPoints = "+mPoints );
		
		//�\�ʂ̉�]������ݒ肷�邽�߂̃��\�b�h�炵���B
		//GL_CW���Ǝ��v���
		//GL_CCW���Ɣ����v���ɂȂ�炵����
		gl.glFrontFace( GL10.GL_CW );
		
		sphereVertex.order( ByteOrder.nativeOrder() );
		
		gl.glEnableClientState( GL10.GL_VERTEX_ARRAY );
		gl.glVertexPointer( 3, GL10.GL_FLOAT, 0, sphereVertex );
		gl.glColor4f( color_r, color_g, color_b, 1.0f );
		gl.glDrawArrays( GL10.GL_LINES, 0, mPoints );
//		Log.v(TAG_NAME, "color (R, G, B) = ("+color_r+", "+color_g+", "+color_b+")");
//		Log.v(TAG_NAME, "position = ("+getPosX()+", "+getPosY()+", "+getPosZ()+")");
		gl.glDisableClientState( GL10.GL_VERTEX_ARRAY );
		
	}
	
	private int buid( double x, double y, double z ){
		/**
		 * ���ꂼ��̒��_���W�����߂鎮�͎��̂悤�ɂȂ�
		 * verX = x + p * sin( phi ) * cos( theta )
		 * verY = y + p * sin( phi ) * sin( theta )
		 * verZ = z + p * cos( phi )
		 */
		
		double dTheta 	= mStep * rad;
		double dPhi		= dTheta;
		int points = 0;
		//���_���W���X�g�ɑ������ۂ̓Y���Ƃ��Ďg�p����
		int count = 0;
		
		for( double phi = -( Math.PI ); phi <= 0; phi += dPhi ){
			for( double theta = 0.0; theta <= ( Math.PI * 2 ); theta += dTheta ){
//				Log.v(TAG_NAME+".buid", "posX = "+( /*( float )x + */( float )( radius * Math.sin( phi ) * Math.cos( theta ) ) ));
			//	sphereVertex.asFloatBuffer().put( /*( float )x + */( float )( radius * Math.sin( phi ) * Math.cos( theta ) ) );
		    //	sphereVertex.asFloatBuffer().put( /*( float )y + */( float )( radius * Math.sin( phi ) * Math.sin( theta ) ) );
			//	sphereVertex.asFloatBuffer().put( /*( float )z + */( float )( radius * Math.cos( phi ) ) );
				vertics[ count++ ] = ( float )x + ( float )( radius * Math.sin( phi ) * Math.cos( theta ) );
				vertics[ count++ ] = ( float )y + ( float )( radius * Math.sin( phi ) * Math.sin( theta ) );
				vertics[ count++ ] = ( float )z + ( float )( radius * Math.cos( phi ) );
				points++;
			}
			sphereVertex.asFloatBuffer().put( vertics );
		}
		sphereVertex.position( 0 );
		return points;
	}
}
