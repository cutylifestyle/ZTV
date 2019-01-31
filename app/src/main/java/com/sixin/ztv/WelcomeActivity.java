package com.sixin.ztv;

import android.Manifest;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gyf.barlibrary.BarHide;
import com.gyf.barlibrary.ImmersionBar;
import com.sixin.ztv.base.BaseActivity;
import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.AndPermission;

import java.util.List;

public class WelcomeActivity extends BaseActivity {

    //todo 测试权限工具类的内存泄漏
    //todo 现有机型页面测试：使用的imageView是wrap_content,可能存在问题
    //todo 测试内存占用情况：有28m-----》40m，暂时能够接受，目标内存控制在80m
    //todo 杀死应用进程的情况下，冷启动状态栏会显示一下
    //todo 这个部分后期需要替换成rxJava和mvp
    //todo 权限申请的代码能不能封装到基类中去

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setAllowFullScreen(true);
        super.onCreate(savedInstanceState);
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

                         }
                     })
                     .onDenied(new Action<List<String>>() {
                         @Override
                         public void onAction(List<String> data) {

                         }
                     })
                     .start();
    }
}
