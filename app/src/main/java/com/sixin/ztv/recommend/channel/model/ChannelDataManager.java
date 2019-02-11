package com.sixin.ztv.recommend.channel.model;

import com.google.gson.Gson;
import com.sixin.ztv.App;
import com.sixin.ztv.Http.RetrofitClient;
import com.sixin.ztv.Http.compose.ResponseTransferStation;
import com.sixin.ztv.Http.compose.SchedulerController;
import com.sixin.ztv.Http.observer.CommonObserver;
import com.sixin.ztv.Http.observer.SimpleCommonObserver;
import com.sixin.ztv.Http.response.ResponseListener;
import com.sixin.ztv.recommend.channel.model.bean.ChannelBannerBean;
import com.sixin.ztv.recommend.channel.model.bean.ChannelLevelLableBean;
import com.sixin.ztv.recommend.channel.model.bean.WrappChannelBean;
import com.sixin.ztv.utils.LogUtils;
import com.sixin.ztv.utils.PhoneUtils;
import com.sixin.ztv.utils.Utils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.schedulers.Schedulers;

public class ChannelDataManager implements ChannelModel {


    @Override
    public Disposable getHeaderInfo(ResponseListener<WrappChannelBean> listener,int cateId) {
//        posid	2081201,2081202,2081203,2081204,2081205,2081206
//        roomid	0
//        cate1	0
//        cate2	1
//        chanid	100
//        app	{"aname":"斗鱼直播","pname":"air.tv.douyu.android"}
//        device	{"addid":"16b4c2381ee392ee","devtype":"0","h":"2160","idfa":"","imei":"867951036671598","mac":"34:D7:12:95:E1:58","mfrs":"SMARTISAN","model":"OC105","nt":"1","op":"1","os":"Android","osv":"7.1.2","ua":"Douyu_Android","w":"1080"}
//        imei	867951036671598
//        p	118.358371,31.177319
//        Gson gson = new Gson();
//        Map<String, String> requestBody = new HashMap<>();
//        requestBody.put("posid", "2081201,2081202,2081203,2081204,2081205,2081206");
//        requestBody.put("roomid", "0");
//        requestBody.put("cate1","0");
//        requestBody.put("cate2", Integer.toString(cateId));
//        requestBody.put("chanid", "100");
//        requestBody.put("app", gson.toJson(((App) Utils.getApp()).getmPlatform()));
//        requestBody.put("device", gson.toJson(((App) Utils.getApp()).getDeviceInfo()));
//        requestBody.put("imei", PhoneUtils.getIMEI());
//        requestBody.put("p", "118.358371,31.177319");
//        LogUtils.d(requestBody.toString());
//        return RetrofitClient.getInstance().getRequest()
//                .getChannelBannerInfo(requestBody)
//                .compose(ResponseTransferStation.<List<ChannelBannerBean>>handleReponse())
//                .compose(SchedulerController.<List<ChannelBannerBean>>ioToMain())
//                .subscribeWith(new SimpleCommonObserver<List<ChannelBannerBean>>(listener));
        return Observable.zip(getBannerInfo(cateId), getChannelLevelLableInfo(cateId), new BiFunction<List<ChannelBannerBean>, List<ChannelLevelLableBean>, WrappChannelBean>() {
            @Override
            public WrappChannelBean apply(List<ChannelBannerBean> channelBannerBeans, List<ChannelLevelLableBean> channelLevelLableBeans) throws Exception {
                return new WrappChannelBean(channelBannerBeans,channelLevelLableBeans);
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new SimpleCommonObserver<WrappChannelBean>(listener));
    }


    public Observable<List<ChannelBannerBean>> getBannerInfo(int cateId) {
        Gson gson = new Gson();
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("posid", "2081201,2081202,2081203,2081204,2081205,2081206");
        requestBody.put("roomid", "0");
        requestBody.put("cate1","0");
        requestBody.put("cate2", Integer.toString(cateId));
        requestBody.put("chanid", "100");
        requestBody.put("app", gson.toJson(((App) Utils.getApp()).getmPlatform()));
        requestBody.put("device", gson.toJson(((App) Utils.getApp()).getDeviceInfo()));
        requestBody.put("imei", PhoneUtils.getIMEI());
        requestBody.put("p", "118.358371,31.177319");
        return RetrofitClient.getInstance().getRequest()
                .getChannelBannerInfo(requestBody)
                .compose(ResponseTransferStation.<List<ChannelBannerBean>>handleReponse())
                .subscribeOn(Schedulers.io());

    }

    @Override
    public Observable<List<ChannelLevelLableBean>> getChannelLevelLableInfo(int cateId) {
        return RetrofitClient.getInstance().getRequest()
                .getChannelLevelLableInfo(cateId,"android")
                .compose(ResponseTransferStation.<List<ChannelLevelLableBean>>handleReponse())
                .subscribeOn(Schedulers.io());
    }
}
