package com.example.libingzheng20200106.mvp;

import com.example.libingzheng20200106.base.BaseView;

import java.util.HashMap;
//契约类
public interface Contract {
    interface IModel{
        //左侧model
        void getLeftModel(ModelCallBack callBack);
        //右侧model
        void getRightModel(HashMap<String,String> map,ModelCallBack callBack);
        interface ModelCallBack{
            void success(Object o);
            void error(Object e);
        }
    }
    interface IView extends BaseView{
        void success(Object o);
        void error(Object e);
    }
    interface IPresenter{
        void getLeftModel();
        void getRightModel(HashMap<String,String> params);
    }
}
