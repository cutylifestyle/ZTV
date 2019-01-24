package com.sixin.ztv.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.gyf.barlibrary.ImmersionBar;
import com.sixin.ztv.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public class BaseMvpActivity extends AppCompatActivity {

    private Unbinder mUnbinder;
    private ImmersionBar mImmersionBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        mUnbinder = ButterKnife.bind(this);
        //初始化沉浸式状态栏
        mImmersionBar = ImmersionBar.with(this);
    }

    /**
     * 设置状态栏的颜色
     * //todo 这个部分的写法是失败的，需要重构
     * */
    protected void setStatusBarColor(int color){
        if (mImmersionBar != null) {
            mImmersionBar.statusBarColor(color)
                         .fitsSystemWindows(true)
                         .keyboardEnable(true)
                         .init();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }

        if (mImmersionBar != null) {
            mImmersionBar.destroy();
        }
    }
}
