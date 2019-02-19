package com.sixin.ztv.recommend.channel.fragments.fragment14;

import com.sixin.ztv.base.BasePresenter;
import com.sixin.ztv.base.BaseView;
import com.sixin.ztv.recommend.channel.fragments.fragment14.model.bean.MatchBean;
import com.sixin.ztv.recommend.channel.model.bean.ChannelLevelLableBean;

import java.util.List;

public interface MatchConstract {

    interface View extends BaseView{
        void showMatchInfo(List<MatchBean> matchBeans);
    }

    interface Presenter extends BasePresenter<View>{

        void getMatchInfo(ChannelLevelLableBean channelLevelLableBean);
    }
}
