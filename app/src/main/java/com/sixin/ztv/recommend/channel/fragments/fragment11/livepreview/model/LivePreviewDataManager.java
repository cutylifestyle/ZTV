package com.sixin.ztv.recommend.channel.fragments.fragment11.livepreview.model;

import android.util.Log;

import com.sixin.ztv.Http.RetrofitClient;
import com.sixin.ztv.Http.compose.ResponseTransferStation;
import com.sixin.ztv.Http.compose.SchedulerController;
import com.sixin.ztv.Http.observer.CommonObserver;
import com.sixin.ztv.Http.response.ResponseListener;
import com.sixin.ztv.recommend.channel.fragments.fragment11.livepreview.model.bean.LivePreviewBean;
import com.sixin.ztv.utils.LogUtils;

import java.util.List;

import io.reactivex.disposables.Disposable;

public class LivePreviewDataManager implements LivePreviewModel {

    private int mPosition;

    @Override
    public Disposable getLivePreviewInfo(int subLabelId, final ResponseListener<LivePreviewBean> listener) {
       //todo 这种嵌套了很多层的会不会有问题
        return RetrofitClient.getInstance().getRequest()
                    .getLivePreviewInfo(subLabelId,mPosition)
                    .compose(ResponseTransferStation.<LivePreviewBean>handleReponse())
                    .compose(SchedulerController.<LivePreviewBean>ioToMain())
                    .subscribeWith( new CommonObserver<LivePreviewBean>(){

                        @Override
                        public void onSuccess(LivePreviewBean livePreviewBean) {
                            LogUtils.d("onSuccess");
                            if(livePreviewBean != null){
                                List<LivePreviewBean.ListBean> listBeans = livePreviewBean.getList();
                                if (listBeans != null) {
                                    mPosition += listBeans.size();
                                }
                            }
                            if (listener != null) {
                                listener.onSuccess(livePreviewBean);
                            }
                        }

                        @Override
                        public void onFailure(Throwable e) {
                            LogUtils.d("onFailure"+e.getMessage());
                            if (listener != null) {
                                listener.onFailure(e);
                            }
                        }

                        @Override
                        public void onFinish() {
                            LogUtils.d("onFinish");
                            if (listener != null) {
                                listener.onFinish();
                            }
                        }
                    });
    }

    @Override
    public void resetPosition() {
        mPosition = 0;
    }


}
