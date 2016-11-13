package com.amatorlee.mdemo.presenter;

import com.amatorlee.mdemo.config.Config;
import com.amatorlee.mdemo.model.INewCallBack;
import com.amatorlee.mdemo.model.NewInfo;
import com.amatorlee.mdemo.model.NewsLogic;
import com.amatorlee.mdemo.view.ViewLogic;

import java.util.HashMap;

import retrofit2.Response;

/**
 * Created by AmatorLee on 2016/11/13.
 */

public class Presenter {

    private NewsLogic mNewsLogic;
    private ViewLogic mViewLogic;

    public Presenter(ViewLogic viewLogic) {
        mViewLogic = viewLogic;
        mNewsLogic = new NewsLogic();
    }

    public void getInfo(){
        mViewLogic.showProgress();
        HashMap<String, String> map = new HashMap<>();
        map.put("type","tiyu");
        map.put("key", Config.KEY);
        mNewsLogic.getNew(map, new INewCallBack() {
            @Override
            public void onSucceed(Response<NewInfo> response) {
                NewInfo newInfo = response.body();
                mViewLogic.hideProgress();
                mViewLogic.showInfo(newInfo);
            }

            @Override
            public void onFailure(String 获取新闻信息失败) {
                mViewLogic.hideProgress();
                mViewLogic.showError(获取新闻信息失败);
            }
        });
    }

}
