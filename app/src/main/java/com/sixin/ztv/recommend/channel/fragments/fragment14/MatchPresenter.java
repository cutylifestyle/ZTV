package com.sixin.ztv.recommend.channel.fragments.fragment14;

import com.sixin.ztv.Http.response.ResponseListener;
import com.sixin.ztv.base.RxPresenter;
import com.sixin.ztv.recommend.channel.fragments.fragment14.model.MatchDataManager;
import com.sixin.ztv.recommend.channel.fragments.fragment14.model.MatchModel;
import com.sixin.ztv.recommend.channel.fragments.fragment14.model.bean.MatchBean;
import com.sixin.ztv.recommend.channel.model.bean.ChannelLevelLableBean;
import com.sixin.ztv.utils.LogUtils;

import java.util.List;

public class MatchPresenter extends RxPresenter<MatchConstract.View> implements MatchConstract.Presenter {

    private MatchModel mMatchModel;

    public MatchPresenter(MatchConstract.View view) {
        super(view);
        mMatchModel = new MatchDataManager();
    }

    @Override
    public void getMatchInfo(ChannelLevelLableBean channelLevelLableBean) {
        if (channelLevelLableBean != null) {
            addSubscribe(mMatchModel.getMatchInfo(channelLevelLableBean.getCate2_id(), new ResponseListener<List<MatchBean>>() {
                @Override
                public void onSuccess(List<MatchBean> matchBeans) {
                    LogUtils.d(matchBeans.toString());
                    if (matchBeans != null && matchBeans.size() > 0) {
                        if (mView != null && mView.isActive()) {
                            mView.showMatchInfo(matchBeans);
                        }
                    }//todo 待处理
                }

                @Override
                public void onFailure(Throwable t) {
                    //todo 待处理
                }

                @Override
                public void onFinish() {
                    //todo 待处理
                }
            }));
        }
    }
}
