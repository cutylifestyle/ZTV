package com.sixin.ztv.Http.observer;

import com.sixin.ztv.Http.response.ResponseListener;

import io.reactivex.observers.ResourceObserver;

public class SimpleCommonObserver<T> extends ResourceObserver<T> {
    //todo 该类涉及到了多重匿名内部类的问题，会不会产生内存泄漏
    private ResponseListener<T> mListener;

    public SimpleCommonObserver(ResponseListener<T> listener) {
        mListener = listener;
    }

    @Override
    public void onNext(T t) {
        try{
            if (mListener != null) {
                mListener.onSuccess(t);
            }
        }finally{
            if (mListener != null) {
                mListener.onFinish();
            }
        }
    }

    @Override
    public void onError(Throwable e) {
        try{
            if (mListener != null) {
                mListener.onFailure(e);
            }
        }finally{
            if (mListener != null) {
                mListener.onFinish();
            }
        }
    }

    @Override
    public void onComplete() {

    }
}
