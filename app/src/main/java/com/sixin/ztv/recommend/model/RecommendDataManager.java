package com.sixin.ztv.recommend.model;

import com.sixin.ztv.Http.RetrofitClient;
import com.sixin.ztv.Http.compose.ResponseTransferStation;
import com.sixin.ztv.Http.compose.SchedulerController;
import com.sixin.ztv.Http.observer.SimpleCommonObserver;
import com.sixin.ztv.Http.response.ResponseListener;
import com.sixin.ztv.recommend.model.bean.RecommendChannelBean;

import java.util.List;

import io.reactivex.disposables.Disposable;

public class RecommendDataManager implements RecommendModel{


    @Override
    public Disposable getRecommendChannels(final ResponseListener<List<RecommendChannelBean>> listener) {
        return RetrofitClient.getInstance()
                .getRequest()
                .getRecommendChannels()
                .compose(ResponseTransferStation.<List<RecommendChannelBean>>handleReponse())
                .compose(SchedulerController.<List<RecommendChannelBean>>ioToMain())
                .subscribeWith(new SimpleCommonObserver<>(listener));
    }
}
