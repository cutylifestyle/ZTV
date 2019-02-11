package com.sixin.ztv.recommend.channel.model.bean;

import java.util.List;

public class WrappChannelBean {

    private List<ChannelBannerBean> channelBannerBeans;

    private List<ChannelLevelLableBean> channelLevelLableBeans;

    public WrappChannelBean(List<ChannelBannerBean> channelBannerBeans, List<ChannelLevelLableBean> channelLevelLableBeans) {
        this.channelBannerBeans = channelBannerBeans;
        this.channelLevelLableBeans = channelLevelLableBeans;
    }

    public List<ChannelBannerBean> getChannelBannerBeans() {
        return channelBannerBeans;
    }

    public void setChannelBannerBeans(List<ChannelBannerBean> channelBannerBeans) {
        this.channelBannerBeans = channelBannerBeans;
    }

    public List<ChannelLevelLableBean> getChannelLevelLableBeans() {
        return channelLevelLableBeans;
    }

    public void setChannelLevelLableBeans(List<ChannelLevelLableBean> channelLevelLableBeans) {
        this.channelLevelLableBeans = channelLevelLableBeans;
    }

    @Override
    public String toString() {
        return "WrappChannelBean{" +
                "channelBannerBeans=" + channelBannerBeans +
                ", channelLevelLableBeans=" + channelLevelLableBeans +
                '}';
    }
}
