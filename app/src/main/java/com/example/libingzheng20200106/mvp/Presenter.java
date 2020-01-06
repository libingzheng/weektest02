package com.example.libingzheng20200106.mvp;

import com.example.libingzheng20200106.base.BasePresenter;

import java.util.HashMap;
//Presenter实体类
public class Presenter extends BasePresenter<Contract.IView> implements Contract.IPresenter{

    private Model model;

    @Override
    protected void initModel() {
        model = new Model();
    }

    @Override
    public void getLeftModel() {
        model.getLeftModel(new Contract.IModel.ModelCallBack() {
            @Override
            public void success(Object o) {
                getView().success(o);
            }

            @Override
            public void error(Object e) {
                getView().error(e);
            }
        });
    }

    @Override
    public void getRightModel(HashMap<String, String> params) {
        model.getRightModel(params, new Contract.IModel.ModelCallBack() {
            @Override
            public void success(Object o) {
                getView().success(o);
            }

            @Override
            public void error(Object e) {
                getView().error(e);
            }
        });
    }
}
