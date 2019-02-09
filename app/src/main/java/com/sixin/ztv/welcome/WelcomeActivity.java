package com.sixin.ztv.welcome;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;

import com.gyf.barlibrary.BarHide;
import com.gyf.barlibrary.ImmersionBar;
import com.sixin.ztv.App;
import com.sixin.ztv.R;
import com.sixin.ztv.base.BaseActivity;
import com.sixin.ztv.home.HomeActivity;
import com.sixin.ztv.utils.ActivityUtils;
import com.sixin.ztv.utils.DeviceUtils;
import com.sixin.ztv.utils.LogUtils;
import com.sixin.ztv.utils.PhoneUtils;
import com.sixin.ztv.utils.ScreenUtils;
import com.sixin.ztv.utils.Utils;
import com.sixin.ztv.welcome.model.bean.Device;
import com.sixin.ztv.welcome.model.bean.Platform;
import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Setting;

import java.util.List;

public class WelcomeActivity extends BaseActivity {

    //todo 测试权限工具类的内存泄漏:应用还没有完全启动起来的时候，退出应用测试
    //todo 现有机型页面测试：使用的imageView是wrap_content,可能存在问题
    //todo 测试内存占用情况：有28m-----》40m，暂时能够接受，目标内存控制在80m
    //todo 这个部分后期需要替换成rxJava和mvp
    //todo 权限申请的代码能不能封装到基类中去
    //todo mvp中权限申请的代码放置在什么地方
    //todo 实现一下广告页面

    //todo 抓包
    //todo 看别人是如何结合mvp/retrofit/rxJava来进行网络请求的
    //todo 实践
    private Handler handler = new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        //冷启动优化解决方案
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        //申请应用所需要的权限
        requestAppPermission();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void initImmersionBar() {
        ImmersionBar.with(this)
                    .hideBar(BarHide.FLAG_HIDE_STATUS_BAR)
                    .navigationBarColor(android.R.color.black)
                    .init();
    }

    private void requestAppPermission() {
        String[] permissions = new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.READ_PHONE_STATE
        };
        AndPermission.with(this)
                     .runtime()
                     .permission(permissions)
                     .onGranted(new Action<List<String>>() {
                         @Override
                         public void onAction(List<String> data) {
                             setGlobData();
                             jumpToHome();
                         }
                     })
                     .onDenied(new Action<List<String>>() {
                         @Override
                         public void onAction(List<String> data) {
                             if (AndPermission.hasAlwaysDeniedPermission(WelcomeActivity.this, data)) {
                                 showSettingDialog();
                             }else{
                                 showGrantedDialog();
                             }
                         }
                     })
                     .start();
    }

    private void showSettingDialog() {
        //todo 此处的内存泄漏以及封装的问题
        //todo 代码与showGrantedDialog重复了
        String message = getString(R.string.open_permissions);
        new AlertDialog.Builder(this)
                .setCancelable(false)
                .setMessage(message)
                .setPositiveButton(R.string.granted, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //todo 这种循环嵌套中的内存泄漏问题
                        setPermission();
                    }
                })
                .setNegativeButton(R.string.exit, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ActivityUtils.finishAllActivities();
                    }
                })
                .show();

    }

    private void showGrantedDialog() {
        //todo 此处的内存泄漏以及封装的问题
        String message = getString(R.string.permissions_denied);

        new AlertDialog.Builder(this)
                .setCancelable(false)
                .setMessage(message)
                .setPositiveButton(R.string.granted, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //todo 这种循环嵌套中的内存泄漏问题
                        requestAppPermission();
                    }
                })
                .setNegativeButton(R.string.exit, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ActivityUtils.finishAllActivities();
                    }
                })
                .show();
    }

    private void setPermission() {
        AndPermission.with(this)
                .runtime()
                .setting()
                .onComeback(new Setting.Action() {
                    @Override
                    public void onAction() {
                        String[] permissions = new String[]{
                                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                Manifest.permission.READ_EXTERNAL_STORAGE,
                                Manifest.permission.READ_PHONE_STATE
                        };
                        if(AndPermission.hasPermissions(WelcomeActivity.this, permissions)){
                                setGlobData();
                                jumpToHome();
                        }else{
                            requestAppPermission();
                        }

                    }
                })
                .start();
    }

    private void jumpToHome() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                ActivityUtils.startActivity(new Intent(WelcomeActivity.this, HomeActivity.class));
                finish();
            }
        }, 1500);
    }

    private void setGlobData() {
        Device device = new Device();
        device.setAddid("16b4c2381ee392ee");
        device.setDevtype("0");
        device.setH(Integer.toString(ScreenUtils.getScreenHeight()));
        device.setImei(PhoneUtils.getIMEI());
        //todo 该方法需要联网获取，所有存在问题跳转了页面，值还没有获取到，无网络情况
        device.setMac(DeviceUtils.getMacAddress());
        device.setMfrs(DeviceUtils.getManufacturer());
        device.setModel(DeviceUtils.getModel());
        device.setNt("1");
        device.setOp("1");
        device.setIdfa("");
        device.setOs("Android");
        device.setOsv(DeviceUtils.getSDKVersionName());
        device.setUa("Douyu_Android");
        device.setW(Integer.toString(ScreenUtils.getScreenWidth()));

        Platform platform = new Platform();
        platform.setAname("斗鱼直播");
        platform.setPname("air.tv.douyu.android");

        ((App)Utils.getApp()).setDeviceInfo(device);
        ((App)Utils.getApp()).setmPlatform(platform);
    }

    @Override
    protected void onDestroy() {
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        super.onDestroy();
    }
}
