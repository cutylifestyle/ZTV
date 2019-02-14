package com.sixin.ztv.recommend.channel;

import com.sixin.ztv.Http.response.ResponseListener;
import com.sixin.ztv.base.RxPresenter;
import com.sixin.ztv.recommend.channel.model.ChannelDataManager;
import com.sixin.ztv.recommend.channel.model.ChannelModel;
import com.sixin.ztv.recommend.channel.model.bean.ChannelBannerBean;
import com.sixin.ztv.recommend.channel.model.bean.ChannelLevelLableBean;
import com.sixin.ztv.recommend.channel.model.bean.WrappChannelBean;
import com.sixin.ztv.recommend.model.bean.RecommendChannelBean;
import com.sixin.ztv.utils.LogUtils;

import java.util.ArrayList;
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
                            if (wrappChannelBean != null) {
                                //todo 这部分的代码迁移到model层中
                                List<ChannelBannerBean> channelBannerBeans = wrappChannelBean.getChannelBannerBeans();
                                List<ChannelLevelLableBean> channelLevelLableBeans = wrappChannelBean.getChannelLevelLableBeans();
                                //todo mView的判断封装到父类中去
                                if (channelBannerBeans != null && channelBannerBeans.size() > 0 && mView != null && mView.isActive()) {
                                    mView.showBanners(channelBannerBeans);
                                } else if (channelBannerBeans == null || channelBannerBeans.size() == 0 && mView != null && mView.isActive()) {
                                    mView.hideBanners();
                                }
                                if (channelLevelLableBeans != null && channelLevelLableBeans.size() > 0 && mView != null && mView.isActive()) {
                                    LogUtils.d(channelLevelLableBeans.toString());
                                    List<ChannelLevelLableBean> result = new ArrayList<>();
                                    for (ChannelLevelLableBean channelLevelLableBean : channelLevelLableBeans) {
                                        if (channelLevelLableBean.getIs_tab() != 0) {
                                            result.add(channelLevelLableBean);
                                        }
                                    }
                                    if (result.size() > 0) {
                                        ChannelLevelLableBean extraData = new ChannelLevelLableBean();
                                        extraData.setCate2_id(result.get(0).getCate2_id());
                                        extraData.setComponent_id(11);
                                        extraData.setConf(null);
                                        extraData.setIs_tab(1);
                                        extraData.setTitle("直播");
                                        result.add(0,extraData);
                                        mView.showLevelLabels(result);
                                    }else{
                                        mView.hideLevelLables();
                                    }
                                }else if(channelLevelLableBeans == null || channelLevelLableBeans.size() == 0 && mView != null && mView.isActive()){
                                    mView.hideLevelLables();
                                }

                            }else{
                                //todo 待处理
                            }
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
