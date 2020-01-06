package com.example.libingzheng20200106.api;

import com.example.libingzheng20200106.entity.LeftEntity;
import com.example.libingzheng20200106.entity.RightEntity;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
//接口
public interface ApiService {
    //左侧
    @GET("baweiapi/category")
    Observable<LeftEntity> getLeftData();
    //右侧
    @GET("/baweiapi/shopByCategory")
    Observable<RightEntity> getRightData(@QueryMap  HashMap<String,String> params);
}
