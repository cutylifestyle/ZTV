package com.sixin.ztv.recommend.channel;

import com.sixin.ztv.Http.response.ResponseListener;
import com.sixin.ztv.base.RxPresenter;
import com.sixin.ztv.recommend.channel.model.ChannelDataManager;
import com.sixin.ztv.recommend.channel.model.ChannelModel;
import com.sixin.ztv.recommend.channel.model.bean.ChannelBannerBean;
import com.sixin.ztv.utils.LogUtils;

import java.util.List;

public class ChannelPresenter extends RxPresenter<ChannelContract.View> implements ChannelContract.Presenter{

    private ChannelModel mChannelModel;

    public ChannelPresenter(ChannelContract.View view) {
        super(view);
        mChannelModel = new ChannelDataManager();
    }

    //todo 该方法需要传参数，并且判断是否需要获取头部
    @Override
    public void getHeaderInfo() {
        addSubscribe(mChannelModel.getHeaderInfo(new ResponseListener<List<ChannelBannerBean>>() {
            @Override
            public void onSuccess(List<ChannelBannerBean> channelBannerBeans) {
                LogUtils.d("onSuccess"+channelBannerBeans.toString());
            }

            @Override
            public void onFailure(Throwable t) {
                LogUtils.d("onFailure");
            }

            @Override
            public void onFinish() {
                LogUtils.d("onFinish");
            }
        }));
    }
}
