package com.sixin.ztv.recommend.channel;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sixin.ztv.R;
import com.sixin.ztv.base.BaseMvpFragment;
import com.sixin.ztv.recommend.channel.adapter.LevelLableAdapter;
import com.sixin.ztv.recommend.channel.holder.ImageHolderView;
import com.sixin.ztv.recommend.channel.model.bean.ChannelBannerBean;
import com.sixin.ztv.recommend.channel.model.bean.ChannelLevelLableBean;
import com.sixin.ztv.recommend.model.bean.RecommendChannelBean;
import com.sixin.ztv.utils.LogUtils;
import com.sixin.ztv.widget.convenientbanner.ConvenientBanner;
import com.sixin.ztv.widget.convenientbanner.holder.CBViewHolderCreator;
import com.sixin.ztv.widget.convenientbanner.holder.Holder;
import com.sixin.ztv.widget.convenientbanner.listener.OnItemClickListener;

import net.lucode.hackware.magicindicator.FragmentContainerHelper;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ChannelFragment extends BaseMvpFragment<ChannelContract.Presenter> implements ChannelContract.View, OnItemClickListener {

    private static final String KEY_CHANNEL = "key_channel";
    //todo 修改banner源码使其外观支持圆角
    @BindView(R.id.banner_channel)
    ConvenientBanner<ChannelBannerBean> mBannerChannel;

    @BindView(R.id.indicator_level_label)
    MagicIndicator mIndicatorLevelLabel;



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
    public void showBanners(List<ChannelBannerBean> channelBannerBeans) {
        //TODO 集合的判断进行工具类的封装
        if (channelBannerBeans != null && channelBannerBeans.size() > 0) {
            //todo 这个部分的判断放到父类中
            if (mBannerChannel.getVisibility() == View.GONE || mBannerChannel.getVisibility() == View.INVISIBLE) {
                mBannerChannel.setVisibility(View.VISIBLE);
            }

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
                    .setOnItemClickListener(this)
                    //设置指示器的方向
                    .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT);

            if (channelBannerBeans.size() > 1) {
                //设置两个点图片作为翻页指示器，不设置则没有指示器，可以根据自己需求自行配合自己的指示器,不需要圆点指示器可用不设
                mBannerChannel.setPageIndicator(new int[]{R.drawable.ic_dot_normal, R.drawable.ic_dot_focused});
            }

            if (channelBannerBeans.size() == 1) {
                mBannerChannel.setCanLoop(false);
            }
        } else{
            //todo 待处理
        }
    }

    @Override
    public void hideBanners() {
        if (mBannerChannel != null && (mBannerChannel.getVisibility() == View.VISIBLE || mBannerChannel.getVisibility() == View.INVISIBLE)) {
            mBannerChannel.setVisibility(View.GONE);
        }
    }

    @Override
    public void showLevelLabels(List<ChannelLevelLableBean> channelLevelLableBeans) {
        //todo 碎片中嵌套碎片   代码按照MagicIndicator写一遍  考察switchPages方法  和轮播图的警告
        if (channelLevelLableBeans != null && channelLevelLableBeans.size() > 0) {
            if (mIndicatorLevelLabel != null && (mIndicatorLevelLabel.getVisibility() == View.GONE || mIndicatorLevelLabel.getVisibility() == View.INVISIBLE)) {
                mIndicatorLevelLabel.setVisibility(View.VISIBLE);
            }
            final FragmentContainerHelper fragmentContainerHelper = new FragmentContainerHelper();
            final CommonNavigator commonNavigator = new CommonNavigator(getContext());
            final LevelLableAdapter levelLableAdapter = new LevelLableAdapter(channelLevelLableBeans,getChildFragmentManager(),fragmentContainerHelper);
            commonNavigator.setAdapter(levelLableAdapter);
            mIndicatorLevelLabel.setNavigator(commonNavigator);
            fragmentContainerHelper.attachMagicIndicator(mIndicatorLevelLabel);

            fragmentContainerHelper.handlePageSelected(0,false);
            levelLableAdapter.switchPages(0);
        }else{
            //todo 待处理
        }
    }

    @Override
    public void hideLevelLables() {
        if (mIndicatorLevelLabel != null && (mIndicatorLevelLabel.getVisibility() == View.VISIBLE || mIndicatorLevelLabel.getVisibility() == View.INVISIBLE)) {
            mIndicatorLevelLabel.setVisibility(View.GONE);
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
