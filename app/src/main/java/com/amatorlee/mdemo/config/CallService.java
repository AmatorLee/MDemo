package com.amatorlee.mdemo.config;

import com.amatorlee.mdemo.model.NewInfo;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by AmatorLee on 2016/11/13.
 */

public interface CallService {

    @GET("index")
    Call<NewInfo> getNewInfo(@QueryMap Map<String,String> map);

}
