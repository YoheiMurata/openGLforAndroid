package jp.ac.uec.is.fs.tadalab.hidetaka.lib.opengl;

public abstract class GLObject {
	  //破棄時に呼ばれる
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        dispose();
    }

    //バインド
    public abstract void bind();

    //アンバインド
    public abstract void unbind();

    //解放
    public abstract void dispose();
}
