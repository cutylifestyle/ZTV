package com.sixin.ztv.recommend.channel.fragments.fragment11.model;

import com.sixin.ztv.Http.RetrofitClient;
import com.sixin.ztv.Http.compose.ResponseTransferStation;
import com.sixin.ztv.Http.compose.SchedulerController;
import com.sixin.ztv.Http.observer.SimpleCommonObserver;
import com.sixin.ztv.Http.response.ResponseListener;
import com.sixin.ztv.recommend.channel.fragments.fragment11.model.bean.SubLabelBean;

import java.util.List;

import io.reactivex.disposables.Disposable;

public class Fragment11DataManager implements Fragment11Model {

    @Override
    public Disposable loadSubLabels(int cateId, ResponseListener<List<SubLabelBean>> responseListener) {
        return RetrofitClient.getInstance().getRequest()
                .getSubLabelInfo(cateId)
                .compose(ResponseTransferStation.<List<SubLabelBean>>handleReponse())
                .compose(SchedulerController.<List<SubLabelBean>>ioToMain())
                .subscribeWith(new SimpleCommonObserver<>(responseListener));
    }
}
