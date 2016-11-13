package com.amatorlee.mdemo.model;

import com.amatorlee.mdemo.config.CallService;
import com.amatorlee.mdemo.config.Config;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by AmatorLee on 2016/11/13.
 * 业务逻辑
 */

public class NewsLogic {

    private  CallService callService;

    public NewsLogic() {
        Retrofit mRetrofit = new Retrofit.Builder().baseUrl(Config.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
        callService = mRetrofit.create(CallService.class);
    }

    public void getNew(Map<String,String> map, final INewCallBack callBack){
        Call<NewInfo> call = callService.getNewInfo(map);

        call.enqueue(new Callback<NewInfo>() {
            @Override
            public void onResponse(Call<NewInfo> call, Response<NewInfo> response) {
                if (response.isSuccessful()){
                    callBack.onSucceed(response);
                }else{
                    callBack.onFailure("获取新闻信息失败");
                }
            }

            @Override
            public void onFailure(Call<NewInfo> call, Throwable t) {
                callBack.onFailure("获取新闻信息失败");
            }
        });
    }

}
