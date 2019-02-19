package com.sixin.ztv.recommend.channel.fragments.fragment14.model;

import com.sixin.ztv.Http.RetrofitClient;
import com.sixin.ztv.Http.compose.ResponseTransferStation;
import com.sixin.ztv.Http.compose.SchedulerController;
import com.sixin.ztv.Http.observer.SimpleCommonObserver;
import com.sixin.ztv.Http.response.ResponseListener;
import com.sixin.ztv.recommend.channel.fragments.fragment14.model.bean.MatchBean;

import java.util.List;

import io.reactivex.disposables.Disposable;

public class MatchDataManager implements MatchModel {

    @Override
    public Disposable getMatchInfo(int cateId, ResponseListener<List<MatchBean>> responseListener) {
        return RetrofitClient.getInstance().getRequest()
                    .getMatchInfo(cateId,"android")
                    .compose(ResponseTransferStation.<List<MatchBean>>handleReponse())
                    .compose(SchedulerController.<List<MatchBean>>ioToMain())
                    .subscribeWith(new SimpleCommonObserver<>(responseListener));
    }
}
