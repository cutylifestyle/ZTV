package com.sixin.ztv.recommend.channel.fragments.fragment11.livepreview;

import com.sixin.ztv.base.BasePresenter;
import com.sixin.ztv.base.BaseView;
import com.sixin.ztv.recommend.channel.fragments.fragment11.livepreview.model.bean.LivePreviewBean;
import com.sixin.ztv.recommend.channel.fragments.fragment11.model.bean.SubLabelBean;

import java.util.List;

public interface LivePreviewContract {

    interface View extends BaseView{
        void showLivePreviewInfo(List<LivePreviewBean.ListBean> listBeans,boolean isRefresh);
    }

    interface Presenter extends BasePresenter<View>{
        void loadLivePreviewInfo(SubLabelBean subLabelBean,boolean isRefresh);
    }
}
