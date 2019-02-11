package com.sixin.ztv.recommend.channel.model;

import com.sixin.ztv.Http.response.ResponseListener;
import com.sixin.ztv.recommend.channel.model.bean.ChannelBannerBean;
import com.sixin.ztv.recommend.channel.model.bean.ChannelLevelLableBean;
import com.sixin.ztv.recommend.channel.model.bean.WrappChannelBean;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public interface ChannelModel {

    Disposable getHeaderInfo(ResponseListener<WrappChannelBean> listener, int cateId);

    Observable<List<ChannelBannerBean>> getBannerInfo(int cateId);

    Observable<List<ChannelLevelLableBean>> getChannelLevelLableInfo(int cateId);

}
