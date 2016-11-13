package com.amatorlee.mdemo.model;

import retrofit2.Response;

/**
 * Created by AmatorLee on 2016/11/13.
 */

public interface INewCallBack {

    void onSucceed(Response<NewInfo> response);
    void onFailure(String 获取新闻信息失败);
}
