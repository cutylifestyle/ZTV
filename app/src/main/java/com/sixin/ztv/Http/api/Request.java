package com.sixin.ztv.Http.api;

import com.sixin.ztv.Http.response.Response;
import com.sixin.ztv.recommend.channel.fragments.fragment11.livepreview.model.bean.LivePreviewBean;
import com.sixin.ztv.recommend.channel.fragments.fragment11.model.bean.SubLabelBean;
import com.sixin.ztv.recommend.channel.model.bean.ChannelBannerBean;
import com.sixin.ztv.recommend.channel.model.bean.ChannelLevelLableBean;
import com.sixin.ztv.recommend.model.bean.RecommendChannelBean;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Request {
    //TODO URL参数最后修改到方法参数中
    String BASE_URL = "https://apiv2.douyucdn.cn/";

    String BASE_URL1 = "https://rtbapi.douyucdn.cn/";

    @GET(BASE_URL+"live/Cate/getTabCate1List?client_sys=android")
    Observable<Response<List<RecommendChannelBean>>> getRecommendChannels();

    @FormUrlEncoded
    @POST(BASE_URL1+"japi/sign/app/getinfo?token=12763000_12_e27a30eacac61871_1_85702442&mdid=phone&uid=12763000&client_sys=android")
    Observable<Response<List<ChannelBannerBean>>> getChannelBannerInfo(@FieldMap Map<String,String> requestBody);

    @GET(BASE_URL+"Live/Customcate2/getAllComponentList")
    Observable<Response<List<ChannelLevelLableBean>>> getChannelLevelLableInfo(@Query("cate2_id")int cateId,@Query("client_sys")String clientSys);

    @GET(BASE_URL+"gv2api/rkc/getC3List/{cate_id}?client_sys=android")
    Observable<Response<List<SubLabelBean>>> getSubLabelInfo(@Path("cate_id") int cateId);

    @GET(BASE_URL+"gv2api/rkc/roomlistV1/3_{sub_label_id}/{position}/20/android?client_sys=android")
    Observable<Response<LivePreviewBean>> getLivePreviewInfo(@Path("sub_label_id") int subLabelId,@Path("position") int position);
}
