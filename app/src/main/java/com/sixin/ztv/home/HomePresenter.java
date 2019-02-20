package com.sixin.ztv.home;

import com.sixin.ztv.Http.observer.SimpleCommonObserver;
import com.sixin.ztv.Http.response.ResponseListener;
import com.sixin.ztv.base.RxPresenter;
import com.sixin.ztv.home.model.HomeDataManager;
import com.sixin.ztv.home.model.HomeModel;
import com.sixin.ztv.utils.LogUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Timed;

public class HomePresenter extends RxPresenter<HomeConstract.View> implements HomeConstract.Presenter {

    private HomeModel mHomeModel;

    public HomePresenter(HomeConstract.View view) {
        super(view);
        mHomeModel = new HomeDataManager();
    }

    @Override
    public void getHotSearchInfo() {
        addSubscribe(mHomeModel.getHotSearchInfo(new ResponseListener<String>() {
            @Override
            public void onSuccess(String str) {
                LogUtils.d("----------");
                if (mView != null && mView.isActive()) {
                    mView.showHotSearchInfo(str);
                }
            }

            @Override
            public void onFailure(Throwable t) {

            }

            @Override
            public void onFinish() {

            }
        }));
    }
}
