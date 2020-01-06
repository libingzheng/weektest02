package com.example.libingzheng20200106;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.libingzheng20200106.adapter.LeftAdapter;
import com.example.libingzheng20200106.base.BaseActivity;
import com.example.libingzheng20200106.entity.LeftEntity;
import com.example.libingzheng20200106.mvp.Contract;
import com.example.libingzheng20200106.mvp.Presenter;
import com.example.libingzheng20200106.utils.RetrofitUtil;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
//MainActivity
public class MainActivity extends BaseActivity<Presenter> implements Contract.IView {

    @BindView(R.id.rv_left)
    RecyclerView rv_left;
    @BindView(R.id.rv_right)
    RecyclerView rv_right;
    private Unbinder bind;

    @Override
    protected void initData() {
        if (RetrofitUtil.getInstance().is()){
            presenter.getLeftModel();
        }else {
            Toast.makeText(this, "无网", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void initView() {
        rv_left.setLayoutManager(new LinearLayoutManager(this));
        rv_left.setLayoutManager(new GridLayoutManager(this,2));
        EventBus.getDefault().register(this);
        bind = ButterKnife.bind(this);
    }

    @Override
    protected Presenter initPresenter() {
        return new Presenter();
    }

    @Override
    protected int initLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void success(Object o) {
        if (o instanceof LeftEntity){
            LeftEntity leftEntity= (LeftEntity) o;
            LeftAdapter leftAdapter = new LeftAdapter(this, leftEntity.getCategory());
            rv_left.setAdapter(leftAdapter);
            rv_left.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EventBus.getDefault().register(this);
                }
            });
        }else {}
    }

    @Override
    public void error(Object e) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(bind!=null){
            bind.unbind();
        }
        EventBus.getDefault().unregister(this);
    }
}
