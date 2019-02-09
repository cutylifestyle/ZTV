package com.sixin.ztv.recommend;

import com.sixin.ztv.base.BasePresenter;
import com.sixin.ztv.base.BaseView;
import com.sixin.ztv.recommend.model.bean.RecommendChannelBean;

import java.util.List;

public interface RecommendContract {

    interface View extends BaseView{
        void showIndicator(List<RecommendChannelBean> recommendChannelBeanList);
    }

    interface Presenter extends BasePresenter<View>{

        void getRecommendChannel();

    }

}
