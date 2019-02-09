package com.sixin.ztv.Http.response;

public interface ResponseListener<T> {

    void onSuccess(T t);

    void onFailure(Throwable t);

    void onFinish();

}
