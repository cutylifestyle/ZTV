package com.sixin.ztv;

import android.app.Application;

import com.sixin.ztv.utils.Utils;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化工具类
        Utils.init(this);
    }
}
