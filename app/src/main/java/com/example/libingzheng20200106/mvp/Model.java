package com.example.libingzheng20200106.mvp;

import com.example.libingzheng20200106.api.ApiService;
import com.example.libingzheng20200106.entity.LeftEntity;
import com.example.libingzheng20200106.entity.RightEntity;
import com.example.libingzheng20200106.utils.RetrofitUtil;

import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
//Model实现类
public class Model implements Contract.IModel{
    @Override
    public void getLeftModel(ModelCallBack callBack) {
        RetrofitUtil.getInstance().createservice(ApiService.class)
                .getLeftData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LeftEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LeftEntity leftEntity) {
                        callBack.success(leftEntity);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.error(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getRightModel(HashMap<String, String> map, ModelCallBack callBack) {
        RetrofitUtil.getInstance().createservice(ApiService.class)
                .getRightData(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RightEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RightEntity rightEntity) {
                        callBack.success(rightEntity);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.error(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
