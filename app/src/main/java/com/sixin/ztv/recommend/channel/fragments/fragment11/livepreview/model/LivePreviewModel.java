package com.sixin.ztv.recommend.channel.fragments.fragment11.livepreview.model;

import com.sixin.ztv.Http.response.ResponseListener;
import com.sixin.ztv.recommend.channel.fragments.fragment11.livepreview.model.bean.LivePreviewBean;

import io.reactivex.disposables.Disposable;

public interface LivePreviewModel {

    Disposable getLivePreviewInfo(int subLabelId, int position, ResponseListener<LivePreviewBean> listener);
}
