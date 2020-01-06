package com.example.libingzheng20200106.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
//BaseActivity
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements BaseView {
    public P presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int layout=initLayoutId();
        setContentView(layout);
        //绑定视图
        if (presenter!=null){
            presenter.attachView(this);
        }
        presenter=initPresenter();
        initView();
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract P initPresenter();

    protected abstract int initLayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}
