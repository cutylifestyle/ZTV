package com.sixin.ztv.Http.api;

import com.sixin.ztv.Http.response.Response;
import com.sixin.ztv.recommend.channel.model.bean.ChannelBannerBean;
import com.sixin.ztv.recommend.model.bean.RecommendChannelBean;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Request {
    //TODO URL参数最后修改到方法参数中
    String BASE_URL = "https://apiv2.douyucdn.cn/";

    String BASE_URL1 = "https://rtbapi.douyucdn.cn/";

    @GET(BASE_URL+"live/Cate/getTabCate1List?client_sys=android")
    Observable<Response<List<RecommendChannelBean>>> getRecommendChannels();

    @FormUrlEncoded
    @POST(BASE_URL1+"japi/sign/app/getinfo?token=12763000_12_e27a30eacac61871_1_85702442&mdid=phone&uid=12763000&client_sys=android")
    Observable<Response<List<ChannelBannerBean>>> getChannelBannerInfo(@FieldMap Map<String,String> requestBody);
}
