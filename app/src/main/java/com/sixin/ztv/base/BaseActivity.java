package com.sixin.ztv.base;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.view.WindowManager;

import com.gyf.barlibrary.ImmersionBar;
import com.sixin.ztv.App;
import com.sixin.ztv.R;
import com.sixin.ztv.utils.ActivityUtils;
import com.sixin.ztv.utils.ScreenUtils;
import com.sixin.ztv.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity {
    //todo BaseMvpFragment的封装
    private Unbinder mUnbinder;
    private boolean mAllowFullScreen = false;
    private boolean mAllowScreenRotate = false;

    @Nullable
    @BindView(R.id.toolbar_common)
    Toolbar mToolbarCommon;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置是否允许屏幕全屏
        if (mAllowFullScreen) {
            ScreenUtils.setFullScreen(this);
        }

        setContentView(getLayoutId());
        mUnbinder = ButterKnife.bind(this);

        //初始化通用toolBar
        initCommonToolBar();

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
        //
        loadData();
    }

    private void initCommonToolBar() {
        if (mToolbarCommon != null && getSupportActionBar() == null) {
            setSupportActionBar(mToolbarCommon);
        }
    }

    protected Toolbar getCommonToolbar() {
        return mToolbarCommon;
    }

    protected void loadData(){};

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



    protected void addFragmentV4(Fragment fragment, String tag, int containerId){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(containerId, fragment, tag);
        transaction.commit();
    }



    protected void bindFragment(android.app.Fragment fragment, int containerId){
        android.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(containerId, fragment);
        transaction.commit();
    }



    /**
     * 碎片是否存在
     * @param fragmentTag 碎片的标签
     * @return boolean {@code true}: 存在<br>{@code false}: 不存在
     * */
    protected boolean isFragmentExist(@NonNull String fragmentTag){
        List<Fragment> fragments =  getSupportFragmentManager().getFragments();
        if(fragments != null && fragments.size() > 0){
            for(Fragment fragment:fragments){
                if(fragmentTag.equals(fragment.getTag())){
                    return true;
                }
            }
        }
        return false;

    }



    /**
     * 根据标签显示碎片
     * @param fragmentTag 碎片的标签
     * */
    protected void showFragmentByTag(@NonNull String fragmentTag){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        List<Fragment> fragments =  fragmentManager.getFragments();
        if(fragments != null && fragments.size() > 0){
            for(Fragment fragment:fragments){
                if(fragmentTag.equals(fragment.getTag())){
                    transaction.show(fragment);
                }else{
                    transaction.hide(fragment);
                }
            }
            transaction.commit();
        }
    }



    /**
     * 隐藏所有碎片
     * */
    protected void hideAllFragments(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        List<Fragment> fragments =  fragmentManager.getFragments();
        if(fragments != null && fragments.size() > 0 ){
            for(Fragment fragment:fragments){
                transaction.hide(fragment);
            }
            transaction.commit();
        }
    }

    /**
     * 显示或添加碎片
     * */
    //todo 这个代码耗时比较严重，需要优化
    protected void showOrAddFragment(@NonNull String fragmentTag,@NonNull Fragment fragment, int containerId){
        boolean result = isFragmentExist(fragmentTag);
        if(result){
            showFragmentByTag(fragmentTag);
        }else{
            hideAllFragments();
            addFragmentV4(fragment,fragmentTag,containerId);
        }
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
