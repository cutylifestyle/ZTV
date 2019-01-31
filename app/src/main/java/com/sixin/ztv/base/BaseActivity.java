package com.sixin.ztv.base;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.gyf.barlibrary.ImmersionBar;
import com.sixin.ztv.App;
import com.sixin.ztv.R;
import com.sixin.ztv.utils.ActivityUtils;
import com.sixin.ztv.utils.ScreenUtils;
import com.sixin.ztv.utils.ToastUtils;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity {

    private Unbinder mUnbinder;
    private boolean mAllowFullScreen = false;
    private boolean mAllowScreenRotate = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置是否允许屏幕全屏
        if (mAllowFullScreen) {
            ScreenUtils.setFullScreen(this);
        }

        setContentView(getLayoutId());
        mUnbinder = ButterKnife.bind(this);

        //设置是否允许屏幕旋转
        if (mAllowScreenRotate) {
            ScreenUtils.setUnspecified(this);
        } else {
            ScreenUtils.setPortrait(this);
        }

        //初始化沉浸式状态栏
        initImmersionBar();

        //获取页面跳转传递的参数
        initBundleParams(savedInstanceState);

        //view与数据绑定
        initView();
    }

    private void initBundleParams(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            getBundleParams(savedInstanceState);
        } else if (getIntent() != null && getIntent().getExtras() != null) {
            getBundleParams(getIntent().getExtras());
        }
    }

    /**
     * 获取页面跳转传递的参数,有需要子类可以复写
     * */
    protected void getBundleParams(Bundle bundle) {}

    /**
     * 是否允许屏幕旋转
     * @param isAllowScreenRotate true 允许屏幕旋转 false 不允许屏幕旋转
     * */
    protected void setAllowScreenRotate(boolean isAllowScreenRotate) {
        this.mAllowScreenRotate = isAllowScreenRotate;
    }

    /**
     * 设置页面是否全屏显示
     * @param isAllowFullScreen true 全屏显示 false 非全屏显示
     * */
    protected void setAllowFullScreen(boolean isAllowFullScreen) {
        this.mAllowFullScreen = isAllowFullScreen;
    }

    /**
     * 子类设置布局Id
     * @return the layout id
     */
    protected abstract int getLayoutId();

    protected void initView() {}

    protected void initImmersionBar() {
        ImmersionBar.with(this)
                     .statusBarColor(R.color.colorPrimaryDark)
                     .fitsSystemWindows(true)
                     .keyboardEnable(true)
                     .init();
    }

    protected void startActivity() {
        //todo startActivity以及startActivityForResult的编写
        //todo 软件盘的显示与隐藏
        //todo 网络监听相关
    }

    /**
     * 吐司
     * */
    protected void toast(int resId) {
        ToastUtils.showLong(resId);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }

        ImmersionBar.with(this).destroy();

        App.getRefWatcher(getApplicationContext()).watch(this);
    }
}
