package com.sixin.ztv.scanner;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.gyf.barlibrary.ImmersionBar;
import com.sixin.ztv.R;
import com.sixin.ztv.base.BaseActivity;

public class ScannerActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_scanner;
    }

    @Override
    protected void initImmersionBar() {
        ImmersionBar.with(this)
                .statusBarColor(android.R.color.black)
                .fitsSystemWindows(true)
                .init();
    }

    @Override
    protected void initView() {
        configToolbar();
    }

    private void configToolbar() {
        Toolbar toolbar = getCommonToolbar();
        if (toolbar != null) {
            toolbar.setBackgroundColor(Color.BLACK);
        }
    }

}
