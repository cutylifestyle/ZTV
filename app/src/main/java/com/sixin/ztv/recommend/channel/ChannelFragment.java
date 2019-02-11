package com.sixin.ztv.recommend.channel;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sixin.ztv.R;
import com.sixin.ztv.base.BaseMvpFragment;
import com.sixin.ztv.recommend.channel.holder.ImageHolderView;
import com.sixin.ztv.recommend.channel.model.bean.ChannelBannerBean;
import com.sixin.ztv.recommend.model.bean.RecommendChannelBean;
import com.sixin.ztv.utils.LogUtils;
import com.sixin.ztv.widget.convenientbanner.ConvenientBanner;
import com.sixin.ztv.widget.convenientbanner.holder.CBViewHolderCreator;
import com.sixin.ztv.widget.convenientbanner.holder.Holder;
import com.sixin.ztv.widget.convenientbanner.listener.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ChannelFragment extends BaseMvpFragment<ChannelContract.Presenter> implements ChannelContract.View, OnItemClickListener {

    private static final String KEY_CHANNEL = "key_channel";
    //todo 修改banner源码使其外观支持圆角
    @BindView(R.id.banner_channel)
    ConvenientBanner<ChannelBannerBean> mBannerChannel;

    public ChannelFragment() {
        // Required empty public constructor
    }

    public static ChannelFragment newInstance() {
        ChannelFragment fragment = new ChannelFragment();
        return fragment;
    }

    public static ChannelFragment newInstance(RecommendChannelBean recommendChannelBean) {
        LogUtils.d("newsInstance");
        ChannelFragment fragment = new ChannelFragment();
        Bundle bd = new Bundle();
        bd.putSerializable(KEY_CHANNEL,recommendChannelBean);
        fragment.setArguments(bd);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_channel;
    }

    @Override
    protected ChannelContract.Presenter initPresenter() {
        return new ChannelPresenter(this);
    }

    @Override
    protected void initView() {
//        initBanner();
    }

    @Override
    protected void lazyLoad() {
        mPresenter.getHeaderInfo(getArguments() != null?(RecommendChannelBean) getArguments().get(KEY_CHANNEL):null);
    }

    @Override
    public void showHeader(List<ChannelBannerBean> channelBannerBeans) {
        if (channelBannerBeans != null && channelBannerBeans.size() > 0) {
            mBannerChannel.setPages(new CBViewHolderCreator() {
                @Override
                public Holder createHolder(View itemView) {
                    return new ImageHolderView(itemView);
                }

                @Override
                public int getLayoutId() {
                    return R.layout.layout_channel_banner;
                }
            }, channelBannerBeans)
                    //设置两个点图片作为翻页指示器，不设置则没有指示器，可以根据自己需求自行配合自己的指示器,不需要圆点指示器可用不设
//                .setPageIndicator(new int[]{R.drawable.ic_page_indicator, R.drawable.ic_page_indicator_focused})
                    .setOnItemClickListener(this)
                    //设置指示器的方向
                    .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT)
            ;
        } else{
            //todo 待处理
        }
    }

    @Override
    public boolean isActive() {
        //todo 这个部分需要整改
        return true;
    }

    @Override
    public void onItemClick(int position) {

    }

    @Override
    public void onResume() {
        super.onResume();
        mBannerChannel.startTurning();
    }

    @Override
    public void onPause() {
        super.onPause();
        mBannerChannel.stopTurning();
    }
}
