package com.sixin.ztv.recommend.channel.model;

import com.google.gson.Gson;
import com.sixin.ztv.App;
import com.sixin.ztv.Http.RetrofitClient;
import com.sixin.ztv.Http.compose.ResponseTransferStation;
import com.sixin.ztv.Http.compose.SchedulerController;
import com.sixin.ztv.Http.observer.SimpleCommonObserver;
import com.sixin.ztv.Http.response.ResponseListener;
import com.sixin.ztv.recommend.channel.model.bean.ChannelBannerBean;
import com.sixin.ztv.utils.LogUtils;
import com.sixin.ztv.utils.PhoneUtils;
import com.sixin.ztv.utils.Utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.disposables.Disposable;

public class ChannelDataManager implements ChannelModel {


    @Override
    public Disposable getHeaderInfo(ResponseListener<List<ChannelBannerBean>> listener) {
//        posid	2081201,2081202,2081203,2081204,2081205,2081206
//        roomid	0
//        cate1	0
//        cate2	1
//        chanid	100
//        app	{"aname":"斗鱼直播","pname":"air.tv.douyu.android"}
//        device	{"addid":"16b4c2381ee392ee","devtype":"0","h":"2160","idfa":"","imei":"867951036671598","mac":"34:D7:12:95:E1:58","mfrs":"SMARTISAN","model":"OC105","nt":"1","op":"1","os":"Android","osv":"7.1.2","ua":"Douyu_Android","w":"1080"}
//        imei	867951036671598
//        p	118.358371,31.177319
        Gson gson = new Gson();
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("posid", "2081201,2081202,2081203,2081204,2081205,2081206");
        requestBody.put("roomid", "0");
        requestBody.put("cate1","0");
        //todo 这个部分是动态的，需要修改
        requestBody.put("cate2", "1");
        requestBody.put("chanid", "100");
        requestBody.put("app", gson.toJson(((App) Utils.getApp()).getmPlatform()));
        requestBody.put("device", gson.toJson(((App) Utils.getApp()).getDeviceInfo()));
        requestBody.put("imei", PhoneUtils.getIMEI());
        requestBody.put("p", "118.358371,31.177319");
        LogUtils.d(requestBody.toString());
        return RetrofitClient.getInstance().getRequest()
                .getChannelBannerInfo(requestBody)
                .compose(ResponseTransferStation.<List<ChannelBannerBean>>handleReponse())
                .compose(SchedulerController.<List<ChannelBannerBean>>ioToMain())
                .subscribeWith(new SimpleCommonObserver<List<ChannelBannerBean>>(listener));
    }
}
