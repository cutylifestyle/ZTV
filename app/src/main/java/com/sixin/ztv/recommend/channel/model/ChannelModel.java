package com.sixin.ztv.recommend.channel.model;

import com.sixin.ztv.Http.response.ResponseListener;
import com.sixin.ztv.recommend.channel.model.bean.ChannelBannerBean;

import java.util.List;

import io.reactivex.disposables.Disposable;

public interface ChannelModel {

    Disposable getHeaderInfo(ResponseListener<List<ChannelBannerBean>> listener);

}
