package com.sixin.ztv.recommend.channel.fragments.fragment11.model;

import com.sixin.ztv.Http.response.ResponseListener;
import com.sixin.ztv.recommend.channel.fragments.fragment11.model.bean.SubLabelBean;

import java.util.List;

import io.reactivex.disposables.Disposable;

public interface Fragment11Model {

    Disposable loadSubLabels(int cateId, ResponseListener<List<SubLabelBean>> responseListener);

}
