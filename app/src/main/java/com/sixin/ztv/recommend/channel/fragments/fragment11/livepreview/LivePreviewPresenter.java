package com.sixin.ztv.recommend.channel.fragments.fragment11.livepreview;

import com.sixin.ztv.Http.response.ResponseListener;
import com.sixin.ztv.base.RxPresenter;
import com.sixin.ztv.recommend.channel.fragments.fragment11.livepreview.model.LivePreviewDataManager;
import com.sixin.ztv.recommend.channel.fragments.fragment11.livepreview.model.LivePreviewModel;
import com.sixin.ztv.recommend.channel.fragments.fragment11.livepreview.model.bean.LivePreviewBean;
import com.sixin.ztv.recommend.channel.fragments.fragment11.model.bean.SubLabelBean;
import com.sixin.ztv.utils.LogUtils;

import java.util.List;

public class LivePreviewPresenter extends RxPresenter<LivePreviewContract.View> implements LivePreviewContract.Presenter {
    //todo cardView在5.0一下手机上的测试
    private LivePreviewModel mLivePreviewModel;

    public LivePreviewPresenter(LivePreviewContract.View view) {
        super(view);
        mLivePreviewModel = new LivePreviewDataManager();
    }


    @Override
    public void loadLivePreviewInfo(SubLabelBean subLabelBean, final boolean isRefresh) {
        //todo 这个部分重新写，分开来写
        if (subLabelBean != null) {
            if (isRefresh) {
                mLivePreviewModel.resetPosition();
            }
            addSubscribe(mLivePreviewModel.getLivePreviewInfo(subLabelBean.getId(), new ResponseListener<LivePreviewBean>() {
                @Override
                public void onSuccess(LivePreviewBean livePreviewBean) {
                    if(livePreviewBean != null && mView != null && mView.isActive()){
                        List<LivePreviewBean.ListBean> listBeans = livePreviewBean.getList();
                        mView.showLivePreviewInfo(listBeans,isRefresh);
                    }//todo 添加else if 的代码
                }

                @Override
                public void onFailure(Throwable t) {
                    //TODO 待处理
                }

                @Override
                public void onFinish() {

                }
            }));
        }
    }
}
