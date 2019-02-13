package com.sixin.ztv.recommend;


import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.ViewPager;
import android.view.animation.OvershootInterpolator;
import android.widget.LinearLayout;

import com.sixin.ztv.R;
import com.sixin.ztv.base.BaseMvpFragment;
import com.sixin.ztv.recommend.adapter.IndicatorAdapter;
import com.sixin.ztv.recommend.adapter.ViewPagerAdapter;
import com.sixin.ztv.recommend.model.bean.RecommendChannelBean;
import com.sixin.ztv.utils.LogUtils;

import net.lucode.hackware.magicindicator.FragmentContainerHelper;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;

import java.util.List;

import butterknife.BindView;

public class RecommendFragment extends BaseMvpFragment<RecommendContract.Presenter> implements RecommendContract.View{
    //todo UI调整，尺寸适配  适配器内存泄漏测试  碎片本身都是隐藏的所以内存增长测试
    //todo viewPager不要保存状态
    @BindView(R.id.indicator_recommend)
    MagicIndicator mIndicatorRecommend;

    @BindView(R.id.vp_channel)
    ViewPager mVpChannel;

    private ViewPagerAdapter mViewPagerAdapter;
    private IndicatorAdapter mIndicatorApdater;

    public RecommendFragment() {
        // Required empty public constructor
    }

    public static RecommendFragment newInstance() {
        RecommendFragment fragment = new RecommendFragment();
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_recommend;
    }

    @Override
    protected void initView() {
        initViewPager();
        initIndicator();
    }

    private void initViewPager() {
        mViewPagerAdapter = new ViewPagerAdapter(getFragmentManager(), null);
        mVpChannel.setAdapter(mViewPagerAdapter);
    }

    private void initIndicator() {
        mIndicatorApdater = new IndicatorAdapter(null, mVpChannel);
        CommonNavigator commonNavigator = new CommonNavigator(getContext());
        commonNavigator.setAdapter(mIndicatorApdater);
        mIndicatorRecommend.setNavigator(commonNavigator);
//        LinearLayout titleContainer = commonNavigator.getTitleContainer(); // must after setNavigator
//        titleContainer.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
//        titleContainer.setDividerDrawable(new ColorDrawable() {
//            @Override
//            public int getIntrinsicWidth() {
//                return UIUtil.dip2px(getContext(), 10);
//            }
//        });
        final FragmentContainerHelper fragmentContainerHelper = new FragmentContainerHelper(mIndicatorRecommend);
        fragmentContainerHelper.setInterpolator(new OvershootInterpolator(2.0f));
        fragmentContainerHelper.setDuration(300);
        mVpChannel.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                fragmentContainerHelper.handlePageSelected(position);
            }
        });
    }

    @Override
    protected void loadData() {
        mPresenter.getRecommendChannel();
    }

    @Override
    protected RecommendContract.Presenter initPresenter() {
        return new RecommendPresenter(this);
    }

    @Override
    public void showIndicator(final List<RecommendChannelBean> recommendChannelBeanList) {
        if (recommendChannelBeanList != null && recommendChannelBeanList.size() > 0) {
            LogUtils.d(recommendChannelBeanList.toString());
            mIndicatorApdater.setData(recommendChannelBeanList);
            mIndicatorRecommend.getNavigator().notifyDataSetChanged();
            mViewPagerAdapter.setData(recommendChannelBeanList);
            mViewPagerAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public boolean isActive() {
        //todo 需要确定填写什么
        return true;
    }
}
