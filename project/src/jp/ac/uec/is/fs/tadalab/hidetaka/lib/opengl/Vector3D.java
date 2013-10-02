package jp.ac.uec.is.fs.tadalab.hidetaka.lib.opengl;

/*
 * �R�����x�N�g���̃f�[�^��\������N���X
 */
public class Vector3D {
	
	private static final int NUM_DIMENTION = 3;

	private float x;
	private float y;
	private float z;
	
	/*�R���X�g���N�^ */
	public Vector3D(){
		x = y = z = 0;
	}
	
	public Vector3D( float x, float y, float z ){
		set( x, y, z );
	}
	
	/*
	 * ���ς̌v�Z���s�Ȃ�
	 */
	public float dot( float x, float y, float z ){
		return ( ( this.x * x ) + ( this.y * y ) + ( this.z * z ) );
	}
	
	public float dot( Vector3D d ){
		return ( ( this.x * d.x ) + ( this.y * d.y ) + ( this.z * d.z ) );
	}
	
	/*
	 * �O�ς̌v�Z
	 * �����̃x�N�g���Ƃ̊O�ς̌��ʂ������Ɋi�[
	 */
	public void cross( Vector3D d ){
		set( ( this.y * z - this.z * d.y ), ( this.z * d.x ) - ( this.x * d.z ),
				( this.x * d.y ) - ( this.y * d.x ) );
	}
	
	public Vector3D cross( Vector3D d, Vector3D result ){
		result.set( ( this.y * z - this.z * d.y ), ( this.z * d.x ) - ( this.x * d.z ),
				( this.x * d.y ) - ( this.y * d.x ) );
		return result;
	}
	
	public void cross( float x, float y, float z ){
		set( ( this.y * z - this.z * y ), ( this.z * x ) - ( this.x * z ),
				( this.x * y ) - ( this.y * x ) );
	}
	
	public void add( Vector3D dd, Vector3D ee ){
		x = dd.x + ee.x;
		y = dd.y + ee.y;
		z = dd.z + ee.z;
	}
	
	public void sub( Vector3D dd, Vector3D ee ){
		x = dd.x - ee.x;
		y = dd.y - ee.y;
		z = dd.z - ee.z;
	}
	
	public float length( ){
		return ( float )Math.sqrt( ( double )( x * x + y * y + z * z) );
	}
	
	/*
	 * �x�N�g���̐��K��
	 */
	public void normalize(){
		final float len = length();
		set( x / len, y / len, z / len );
	}
	
	@Override
	public boolean equals( Object o ){
		Vector3D d = ( Vector3D )o;
		return( this.x == d.x && this.y == d.y && this.z == d.z );
	}
	
	public void set( float xx, float yy, float zz ){
		x = xx;
		y = yy;
		z = zz;
	}
	
	public float[] get(){
		float[] result = new float[ NUM_DIMENTION ];
		
		result[ 0 ] = x;
		result[ 1 ] = y;
		result[ 2 ] = z;
		
		return result;
	}
	
	public float getX(){
		return x;
	}
	
	public float getY(){
		return y;
	}
	
	public float getZ(){
		return z;
	}
	
}
