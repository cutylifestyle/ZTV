package com.sixin.ztv.home.model;

import com.sixin.ztv.Http.observer.CommonObserver;
import com.sixin.ztv.Http.observer.SimpleCommonObserver;
import com.sixin.ztv.Http.response.ResponseListener;
import com.sixin.ztv.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

public class HomeDataManager implements HomeModel {
    private List<String> data = new ArrayList<>();

    @Override
    public Disposable getHotSearchInfo(final ResponseListener<String> responseListener) {
        //todo 有没有操作符能实现我想要的结果
        data.add("旭旭宝宝");
        data.add("妍妍");
        data.add("一起看");
        data.add("还愿");
        data.add("小米");
        data.add("一条小团团");
        return Observable.interval(0,5000, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<Long, String>() {
                    @Override
                    public String apply(Long aLong) throws Exception {
                        int result = (int) (aLong % data.size());
                        return data.get(result);
                    }
                })
                .subscribeWith(new SimpleCommonObserver<>(responseListener));
    }
}
