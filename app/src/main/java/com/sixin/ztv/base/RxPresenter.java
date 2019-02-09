package com.sixin.ztv.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * 所有实现类都必须继承该类释放资源，防止造成内存泄漏
 * */
public class RxPresenter<T extends BaseView> implements BasePresenter<T> {
    protected T mView;
    private CompositeDisposable mCompositeDisposable;

    public RxPresenter(T view){
        if (view == null) {
            throw new NullPointerException();
        }
        mView = view;
        mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    public void addSubscribe(Disposable subscription) {
        mCompositeDisposable.add(subscription);
    }

    @Override
    public void unSubscribe() {
        if (mView != null) {
            mView = null;
        }

        if (mCompositeDisposable != null) {
            mCompositeDisposable.clear();
            mCompositeDisposable = null;
        }

    }
}
