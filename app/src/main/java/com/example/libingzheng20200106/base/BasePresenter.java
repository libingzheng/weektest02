package com.example.libingzheng20200106.base;

import java.lang.ref.WeakReference;
//BasePresenter
public abstract class BasePresenter<V extends BaseView> {

    //弱引用
    private WeakReference<V> weakReference;

    public BasePresenter(){
        initModel();
    }
    //绑定
    public void attachView(V v){
        weakReference = new WeakReference<>(v);
    }
    //解绑
    public void detachView(){
        if (weakReference!=null){
            weakReference.clear();
            weakReference=null;
        }
    }
    protected abstract void initModel();

    public V getView(){
        V v = weakReference.get();
        return v;
    }

}
