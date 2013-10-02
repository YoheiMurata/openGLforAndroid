package jp.ac.uec.is.fs.tadalab.hidetaka.lib.opengl;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import android.opengl.GLES20;
import android.opengl.Matrix;

//2D�O���t�B�b�N�X
public class Graphics {
  public  int         screenW;     //��ʕ�
  public  int         screenH;     //��ʍ���
  private FloatBuffer vertexBuffer;//���_�o�b�t�@
  private FloatBuffer uvBuffer;    //UV�o�b�t�@
  
  //�R���X�g���N�^
  public Graphics(int screenW,int screenH) {
      this.screenW=screenW;
      this.screenH=screenH;
      
      //���_�o�b�t�@�̐���
      float[] vertexs={
          -1.0f, 1.0f,0.0f,//���_0
          -1.0f,-1.0f,0.0f,//���_1
           1.0f, 1.0f,0.0f,//���_2
           1.0f,-1.0f,0.0f,//���_3
      };
      vertexBuffer=makeFloatBuffer(vertexs);
      
      //UV�o�b�t�@�̐���
      float[] uvs={
          0.0f,0.0f,//����
          0.0f,1.0f,//����
          1.0f,0.0f,//�E��
          1.0f,1.0f,//�E��
      };
      uvBuffer=makeFloatBuffer(uvs);  
  }
  
  //float�z��float�o�b�t�@
  private FloatBuffer makeFloatBuffer(float[] array) {
      FloatBuffer fb=ByteBuffer.allocateDirect(array.length*4).order(
          ByteOrder.nativeOrder()).asFloatBuffer();
      fb.put(array).position(0);
      return fb;
  }
  
  //2D�`��̐ݒ�
  public void setup2D() {
      //���_�z��̗L����
      GLES20.glEnableVertexAttribArray(GLES.positionHandle);
      GLES20.glEnableVertexAttribArray(GLES.uvHandle);      
  	
      //�f�v�X�e�X�g�ƌ����̖�����
  	GLES20.glDisable(GLES20.GL_DEPTH_TEST);
      GLES20.glUniform1i(GLES.useLightHandle,0);
      
      //�u�����h�̎w��
      GLES20.glEnable(GLES20.GL_BLEND);
      GLES20.glBlendFunc(GLES20.GL_SRC_ALPHA,GLES20.GL_ONE_MINUS_SRC_ALPHA);
      
      //�ˉe�ϊ�
      Matrix.setIdentityM(GLES.pMatrix,0);         
      GLES20.glUniform4fv(GLES.colorHandle,1,new float[]{1,1,1,1},0);
      GLES20.glVertexAttribPointer(GLES.uvHandle,2,
          GLES20.GL_FLOAT,false,0,uvBuffer);        
  }    

  //�C���[�W�̕`��
  public void drawImage(Texture texture,int x,int y) {
      drawImage(texture,x,y,texture.width,texture.height);
  }
  
  //�C���[�W�̕`��
  public void drawImage(Texture texture,int x,int y,int w,int h) {
      drawImage(texture,x,y,w,h,0,0,texture.width,texture.height);
  }
  
  //�C���[�W�̕`��
  public void drawImage(Texture texture,int dx,int dy,int dw,int dh,
      int sx,int sy,int sw,int sh) {
  	//�E�B���h�E���W�𐳋K���f�o�C�X���W�ɕϊ�
      float tw=(float)sw/(float)texture.width;
      float th=(float)sh/(float)texture.height;
      float tx=(float)sx/(float)texture.width;
      float ty=(float)sy/(float)texture.height;
      
      //�e�N�X�`���̃o�C���h
      texture.bind();
      
      //�e�N�X�`���s��̈ړ��E�g�k
      Matrix.setIdentityM(GLES.texMatrix,0);         
      Matrix.translateM(GLES.texMatrix,0,tx,ty,0.0f);
      Matrix.scaleM(GLES.texMatrix,0,tw,th,1.0f);    
      GLES20.glUniformMatrix4fv(GLES.texMatrixHandle,1,
          false,GLES.texMatrix,0);        
      
      //�E�B���h�E���W�𐳋K���f�o�C�X���W�ɕϊ�
      float mx=((float)dx/(float)screenW)*2.0f-1.0f;
      float my=((float)dy/(float)screenH)*2.0f-1.0f;
      float mw=((float)dw/(float)screenW);
      float mh=((float)dh/(float)screenH);
      
      //���f���r���[�s��̈ړ��E�g�k
      Matrix.setIdentityM(GLES.mMatrix,0);         
      Matrix.translateM(GLES.mMatrix,0,mx+mw,-(my+mh),0.0f);
      Matrix.scaleM(GLES.mMatrix,0,mw,mh,1.0f);                               
      GLES20.glUniformMatrix4fv(GLES.mMatrixHandle,1,
          false,GLES.mMatrix,0);        
      GLES.updateMatrix();
      
      //�l�p�`�̕`��
      GLES20.glVertexAttribPointer(GLES.positionHandle,3,
          GLES20.GL_FLOAT,false,0,vertexBuffer);
      GLES20.glDrawArrays(GLES20.GL_TRIANGLE_STRIP,0,4);
      
      //�e�N�X�`���̃A���o�C���h
      texture.unbind();
  }
}