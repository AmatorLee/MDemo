package com.amatorlee.mdemo.view;

import com.amatorlee.mdemo.model.NewInfo;

/**
 * Created by AmatorLee on 2016/11/13.
 */

public interface ViewLogic {

    void showProgress();
    void hideProgress();


    void showInfo(NewInfo newInfo);

    void showError(String 获取新闻信息失败);

}
