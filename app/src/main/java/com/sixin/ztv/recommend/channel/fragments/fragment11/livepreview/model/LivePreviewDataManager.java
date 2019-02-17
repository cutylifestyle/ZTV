package com.sixin.ztv.recommend.channel.fragments.fragment11.livepreview.model;

import com.sixin.ztv.Http.RetrofitClient;
import com.sixin.ztv.Http.compose.ResponseTransferStation;
import com.sixin.ztv.Http.compose.SchedulerController;
import com.sixin.ztv.Http.observer.SimpleCommonObserver;
import com.sixin.ztv.Http.response.ResponseListener;
import com.sixin.ztv.recommend.channel.fragments.fragment11.livepreview.model.bean.LivePreviewBean;

import java.util.List;

import io.reactivex.disposables.Disposable;

public class LivePreviewDataManager implements LivePreviewModel {


    @Override
    public Disposable getLivePreviewInfo(int subLabelId, int position, ResponseListener<LivePreviewBean> listener) {
        return RetrofitClient.getInstance().getRequest()
                    .getLivePreviewInfo(subLabelId,position)
                    .compose(ResponseTransferStation.<LivePreviewBean>handleReponse())
                    .compose(SchedulerController.<LivePreviewBean>ioToMain())
                    .subscribeWith(new SimpleCommonObserver<>(listener));
    }
}
