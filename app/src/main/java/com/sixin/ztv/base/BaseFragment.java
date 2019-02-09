package com.sixin.ztv.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sixin.ztv.App;
import com.sixin.ztv.utils.ToastUtils;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public abstract class BaseFragment extends Fragment {

    //todo 懒加载测试  viewPager中是否奏效
    //todo startActivity以及startActivityForResult的编写
    //todo 软件盘的显示与隐藏
    //todo 网络监听相关
    //todo 探讨在viewPager中懒加载代码是如何走的
    private Unbinder mUnbinder;

    //懒加载标志位
    private boolean isFirst;
    private boolean isFragmentVisible;

    private View mRootView;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if (isVisibleToUser) {
            isFragmentVisible = true;
        }
        if (mRootView == null) {
            return;
        }
        //可见，并且没有加载过
        if (!isFirst&&isFragmentVisible) {
            onFragmentVisibleChange(true);
            isFirst = true;
            return;
        }
        //由可见——>不可见 已经加载过
        if (isFragmentVisible) {
            onFragmentVisibleChange(false);
            isFragmentVisible = false;
        }

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(getLayoutId(), container, false);
        mUnbinder = ButterKnife.bind(this,mRootView);
        //view与数据绑定
        initView();
        //可见，但是并没有加载过
        //todo 这个if else需要严格测试
        if (isFragmentVisible && !isFirst) {
            onFragmentVisibleChange(true);
            isFirst = true;
        }else{
            loadData();
        }

        return mRootView;
    }

    protected void initView() {}

    /**
     * 当前fragment可见状态发生变化时会回调该方法
     * 如果当前fragment是第一次加载，等待onCreateView后才会回调该方法，其它情况回调时机跟 {@link #setUserVisibleHint(boolean)}一致
     * 在该回调方法中你可以做一些加载数据操作，甚至是控件的操作.
     * @param isVisible true  不可见 -> 可见
     *                  false 可见  -> 不可见
     */
    private void onFragmentVisibleChange(boolean isVisible) {
        if (isVisible) {
            lazyLoad();
        }else{
            cancelLazyLoad();
        }
    }

    protected void loadData() {}

    protected void cancelLazyLoad() {}

    protected void lazyLoad() {}

    protected abstract int getLayoutId();

    /**
     * 吐司
     * */
    protected void toast(int resId) {
        ToastUtils.showLong(resId);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        //todo mUnbinder放置在什么位置解绑好
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
        App.getRefWatcher(getContext()).watch(this);
    }
}
