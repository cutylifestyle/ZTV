package com.sixin.ztv.base;

import io.reactivex.disposables.Disposable;

public interface BasePresenter<T> {

    void addSubscribe(Disposable subscription);

    void unSubscribe();
}
