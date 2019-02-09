package com.sixin.ztv;

import android.app.Application;
import android.content.Context;

import com.facebook.stetho.Stetho;
import com.sixin.ztv.utils.Utils;
import com.sixin.ztv.welcome.model.bean.Device;
import com.sixin.ztv.welcome.model.bean.Platform;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

public class App extends Application {

    private RefWatcher mRefWatcher;
    private Device mDevice;
    private Platform mPlatform;

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

    public void setDeviceInfo(Device deviceInfo) {
        mDevice = deviceInfo;
    }

    public Device getDeviceInfo() {
        return mDevice;
    }

    public Platform getmPlatform() {
        return mPlatform;
    }

    public void setmPlatform(Platform mPlatform) {
        this.mPlatform = mPlatform;
    }
}
