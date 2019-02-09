package com.sixin.ztv.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseMvpFragment<T extends BasePresenter> extends BaseFragment {

    protected  T mPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mPresenter = initPresenter();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    protected abstract T initPresenter();

    @Override
    public void onDetach() {
        if (mPresenter != null) {
            mPresenter.unSubscribe();
            mPresenter = null;
        }
        super.onDetach();
    }
}
