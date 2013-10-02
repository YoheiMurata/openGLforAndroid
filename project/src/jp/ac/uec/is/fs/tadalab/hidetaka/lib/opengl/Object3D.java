package jp.ac.uec.is.fs.tadalab.hidetaka.lib.opengl;

import java.util.ArrayList;

import android.opengl.Matrix;

public class Object3D {
		public Figure  figure;                     //ÉtÉBÉMÉÖÉA
	    public Vector3D position=new Vector3D();     //à íu
	    public Vector3D rotate  =new Vector3D();     //âÒì]
	    public Vector3D scale   =new Vector3D(1,1,1);//ägèk
	    public ArrayList<Object3D> childs=new ArrayList<Object3D>();//éq
	    
	    //ï`âÊ
	    public void draw() {
	        GLES.glPushMatrix();
	        Matrix.translateM(GLES.mMatrix,0,position.getX(),position.getY(),position.getZ());
	        Matrix.rotateM(GLES.mMatrix,0,rotate.getZ(),0,0,1);
	        Matrix.rotateM(GLES.mMatrix,0,rotate.getY(),0,1,0);
	        Matrix.rotateM(GLES.mMatrix,0,rotate.getX(),1,0,0);
	        Matrix.scaleM(GLES.mMatrix,0,scale.getX(),scale.getY(),scale.getZ());
	        GLES.updateMatrix();
	        figure.draw();
	        for (int i=0;i<childs.size();i++) childs.get(i).draw();
	        GLES.glPopMatrix();
	    }
}
