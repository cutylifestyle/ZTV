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
import com.sixin.ztv.utils.ToastUtils;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity {

    private Unbinder mUnbinder;
    private boolean mAllowFullScreen = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置是否允许屏幕全屏
        if (mAllowFullScreen) {
            this.requestWindowFeature(Window.FEATURE_NO_TITLE);
            this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                                        WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        setContentView(getLayoutId());
        mUnbinder = ButterKnife.bind(this);
        //设置是否允许屏幕旋转  todo 这个部分修改一下
        if (isAllowScreenRotate()) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        } else {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
        //初始化沉浸式状态栏
        initImmersionBar();
        //view与数据绑定
        initView();
    }

    /**
     * 是否允许屏幕旋转，默认是false,不允许屏幕旋转
     * */
    protected boolean isAllowScreenRotate() {
        return false;
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
     *
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
