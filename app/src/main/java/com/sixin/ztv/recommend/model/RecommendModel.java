package com.sixin.ztv.recommend.model;

import com.sixin.ztv.Http.response.ResponseListener;
import com.sixin.ztv.recommend.model.bean.RecommendChannelBean;

import java.util.List;

import io.reactivex.disposables.Disposable;

public interface RecommendModel {

    Disposable getRecommendChannels(ResponseListener<List<RecommendChannelBean>> listener);

}
