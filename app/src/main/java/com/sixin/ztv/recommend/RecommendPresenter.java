package com.sixin.ztv.recommend;

import com.sixin.ztv.Http.response.ResponseListener;
import com.sixin.ztv.base.RxPresenter;
import com.sixin.ztv.recommend.model.RecommendDataManager;
import com.sixin.ztv.recommend.model.RecommendModel;
import com.sixin.ztv.recommend.model.bean.RecommendChannelBean;
import com.sixin.ztv.utils.LogUtils;

import java.util.List;

public class RecommendPresenter extends RxPresenter<RecommendContract.View> implements RecommendContract.Presenter {

    private RecommendModel recommendModel;

    public RecommendPresenter(RecommendContract.View view) {
        super(view);
        recommendModel = new RecommendDataManager();
    }

    @Override
    public void getRecommendChannel() {
        addSubscribe(recommendModel.getRecommendChannels(new ResponseListener<List<RecommendChannelBean>>() {
            @Override
            public void onSuccess(List<RecommendChannelBean> recommendChannelBeans) {
                if (mView != null && mView.isActive()) {
                    if (recommendChannelBeans != null && recommendChannelBeans.size() > 0) {
                        mView.showIndicator(recommendChannelBeans);
                    }else{
                        //TODO 待处理
                    }
                }
            }

            @Override
            public void onFailure(Throwable t) {
                if (mView != null && mView.isActive()) {
                    //TODO 待处理
                }
            }

            @Override
            public void onFinish() {
                if (mView != null && mView.isActive()) {
                    //TODO 待处理
                }
            }
        }));
    }
}
