package com.sixin.ztv.home;

import com.sixin.ztv.base.BasePresenter;
import com.sixin.ztv.base.BaseView;

public interface HomeConstract {

    interface View extends BaseView {
        void showHotSearchInfo(String hotSearch);
    }

    interface Presenter extends BasePresenter<View> {
        void getHotSearchInfo();
    }

}
