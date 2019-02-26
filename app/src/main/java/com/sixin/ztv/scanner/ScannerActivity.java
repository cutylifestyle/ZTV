package com.sixin.ztv.scanner;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.google.zxing.Result;
import com.google.zxing.client.result.ParsedResult;
import com.gyf.barlibrary.ImmersionBar;
import com.sixin.ztv.R;
import com.sixin.ztv.base.BaseActivity;
import com.sixin.zxing.OnScannerCompletionListener;
import com.sixin.zxing.ScannerView;

import butterknife.BindView;

public class ScannerActivity extends BaseActivity implements OnScannerCompletionListener {

    @BindView(R.id.sv_scanner)
    ScannerView mSvScanner;

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
        configScanner();
    }

    private void configScanner() {
        mSvScanner.setOnScannerCompletionListener(this);
        mSvScanner.setLaserFrameSize(200, 200);
    }

    private void configToolbar() {
        Toolbar toolbar = getCommonToolbar();
        if (toolbar != null) {
            toolbar.setBackgroundColor(Color.BLACK);
        }
    }

    @Override
    protected void onResume() {
        mSvScanner.onResume();
        super.onResume();
    }

    @Override
    protected void onPause() {
        mSvScanner.onPause();
        super.onPause();
    }

    @Override
    public void onScannerCompletion(Result rawResult, ParsedResult parsedResult, Bitmap barcode) {

    }
}
