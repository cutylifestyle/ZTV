package com.sixin.ztv.recommend.channel;

import com.sixin.ztv.Http.response.ResponseListener;
import com.sixin.ztv.base.RxPresenter;
import com.sixin.ztv.recommend.channel.model.ChannelDataManager;
import com.sixin.ztv.recommend.channel.model.ChannelModel;
import com.sixin.ztv.recommend.channel.model.bean.ChannelBannerBean;
import com.sixin.ztv.recommend.channel.model.bean.WrappChannelBean;
import com.sixin.ztv.recommend.model.bean.RecommendChannelBean;
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
    public void getHeaderInfo(RecommendChannelBean recommendChannelBean) {
        if (recommendChannelBean != null) {
            switch (recommendChannelBean.getLevel()) {
                case 1:
                    break;
                case 2:
                    addSubscribe(mChannelModel.getHeaderInfo(new ResponseListener<WrappChannelBean>() {

                        //todo zip操作符在各种环境中的测试
                        @Override
                        public void onSuccess(WrappChannelBean wrappChannelBean) {
                            LogUtils.d(wrappChannelBean.toString());
                        }

                        @Override
                        public void onFailure(Throwable t) {
                            //todo 待处理
                        }

                        @Override
                        public void onFinish() {
                            //todo 待处理
                        }
                    },recommendChannelBean.getCate_id()));
                    break;
                default:
                    //todo 待处理的
                    break;
            }
        }else{
            //todo 待处理
        }

    }
}
