package com.sixin.ztv;

import android.app.Application;
import android.content.Context;

import com.facebook.stetho.Stetho;
import com.sixin.ztv.utils.Utils;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

public class App extends Application {

    private RefWatcher mRefWatcher;

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化工具类
        Utils.init(this);
        //初始化内存泄漏检测工具
        mRefWatcher = setupLeakCanary();
        //集成facebook的Stetho
        Stetho.initializeWithDefaults(this);
    }

    private RefWatcher setupLeakCanary(){
        if(LeakCanary.isInAnalyzerProcess(this)){
            return RefWatcher.DISABLED;
        }
        return LeakCanary.install(this);
    }

    public static RefWatcher getRefWatcher(Context context) {
        App app = (App) context.getApplicationContext();
        return app.mRefWatcher;
    }
}
