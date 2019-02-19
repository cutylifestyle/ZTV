package com.sixin.ztv.recommend.channel.fragments.fragment14.model;

import com.sixin.ztv.Http.response.ResponseListener;
import com.sixin.ztv.recommend.channel.fragments.fragment14.model.bean.MatchBean;

import java.util.List;

import io.reactivex.disposables.Disposable;

public interface MatchModel {

    Disposable getMatchInfo(int cateId, ResponseListener<List<MatchBean>> responseListener);

}
