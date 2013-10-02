package jp.ac.uec.is.fs.tadalab.hidetaka.lib.opengl;

public abstract class GLObject {
	  //�j�����ɌĂ΂��
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        dispose();
    }

    //�o�C���h
    public abstract void bind();

    //�A���o�C���h
    public abstract void unbind();

    //���
    public abstract void dispose();
}
