package com.sixin.ztv.recommend.channel;

import com.sixin.ztv.base.BasePresenter;
import com.sixin.ztv.base.BaseView;
import com.sixin.ztv.recommend.channel.model.bean.ChannelBannerBean;
import com.sixin.ztv.recommend.channel.model.bean.ChannelLevelLableBean;
import com.sixin.ztv.recommend.model.bean.RecommendChannelBean;

import java.util.List;

public interface ChannelContract {

    interface View extends BaseView{

        void showBanners(List<ChannelBannerBean> channelBannerBeans);

        void hideBanners();

        void showLevelLabels(List<ChannelLevelLableBean> channelLevelLableBeans);

        void hideLevelLables();
    }

    interface Presenter extends BasePresenter<View>{
        void getHeaderInfo(RecommendChannelBean recommendChannelBean);
    }

}
