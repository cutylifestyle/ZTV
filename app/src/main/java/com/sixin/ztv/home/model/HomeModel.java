package com.sixin.ztv.home.model;

import com.sixin.ztv.Http.response.ResponseListener;

import java.util.List;

import io.reactivex.disposables.Disposable;

public interface HomeModel {

    Disposable getHotSearchInfo(ResponseListener<String> responseListener);
}
