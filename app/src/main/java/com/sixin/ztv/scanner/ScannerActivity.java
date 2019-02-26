package com.sixin.ztv.scanner;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.Result;
import com.google.zxing.client.result.ParsedResult;
import com.gyf.barlibrary.ImmersionBar;
import com.sixin.ztv.R;
import com.sixin.ztv.base.BaseActivity;
import com.sixin.ztv.utils.ConvertUtils;
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
        //todo 这儿的尺寸需要统一修改，包括里面的自定义View的text的位置
        mSvScanner.setLaserFrameTopMargin(100);
        mSvScanner.setLaserFrameSize(200, 200);
        mSvScanner.setLaserFrameBoundColor(getResources().getColor(R.color.colorScanner));
        mSvScanner.setLaserColor(getResources().getColor(R.color.colorScanner));
    }

    private void configToolbar() {
        Toolbar toolbar = getCommonToolbar();
        if (toolbar != null) {
            toolbar.setBackgroundColor(Color.BLACK);
            TextView tvTitle = getTvTitle();
            if (tvTitle != null) {
                tvTitle.setText(getResources().getString(R.string.scan));
                tvTitle.setTextColor(Color.WHITE);
                tvTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP,15);
            }
            ImageView imgLeft = getImgLeft();
            if (imgLeft != null) {
                imgLeft.setImageResource(R.drawable.ic_arrow_left);
                int padding = ConvertUtils.dp2px(12);
                imgLeft.setPadding(padding,padding,padding,padding);
            }
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
