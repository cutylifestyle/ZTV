package com.sixin.ztv.Http.observer;


import io.reactivex.observers.ResourceObserver;

public abstract class CommonObserver<T> extends ResourceObserver<T> {

    @Override
    public void onNext(T t) {
        try {
            onSuccess(t);
        }finally{
            onFinish();
        }
    }

    public void onFinish(){}

    public abstract void onSuccess(T t);

    public abstract void onFailure(Throwable e);

    @Override
    public void onError(Throwable e) {
        try{
            onFailure(e);
        }finally{
            onFinish();
        }
    }

    @Override
    public void onComplete() {

    }

}
