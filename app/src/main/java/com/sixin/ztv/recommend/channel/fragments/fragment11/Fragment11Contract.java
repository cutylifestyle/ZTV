package com.sixin.ztv.recommend.channel.fragments.fragment11;

import com.sixin.ztv.base.BasePresenter;
import com.sixin.ztv.base.BaseView;
import com.sixin.ztv.recommend.channel.fragments.fragment11.model.bean.SubLabelBean;
import com.sixin.ztv.recommend.channel.model.bean.ChannelLevelLableBean;

import java.util.List;

public interface Fragment11Contract {

    interface View extends BaseView{

        void showSubLabel(List<SubLabelBean> subLabelBeans);

    }

    interface Presenter extends BasePresenter<View>{

        void loadSubLabel(ChannelLevelLableBean channelLevelLableBean);

    }

}
