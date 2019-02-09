package com.sixin.ztv.recommend.channel;

import com.sixin.ztv.base.BasePresenter;
import com.sixin.ztv.base.BaseView;

public interface ChannelContract {

    interface View extends BaseView{
        void showHeader();
    }

    interface Presenter extends BasePresenter<View>{
        void getHeaderInfo();
    }

}
