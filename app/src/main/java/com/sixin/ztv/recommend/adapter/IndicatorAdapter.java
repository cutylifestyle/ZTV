package com.sixin.ztv.recommend.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.sixin.ztv.recommend.model.bean.RecommendChannelBean;

import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

import java.util.List;

public class IndicatorAdapter extends CommonNavigatorAdapter {

    private List<RecommendChannelBean> data;
    private ViewPager mViewPager;

    public IndicatorAdapter(List<RecommendChannelBean> data,ViewPager viewPager) {
        this.data = data;
        this.mViewPager = viewPager;
    }

    @Override
    public int getCount() {
        return data == null ? 0 :data.size();
    }

    public void setData(List<RecommendChannelBean> data) {
        this.data = data;
    }

    @Override
    public IPagerTitleView getTitleView(Context context, final int index) {
        SimplePagerTitleView simplePagerTitleView = new ColorTransitionPagerTitleView(context);
        simplePagerTitleView.setNormalColor(Color.WHITE);
        simplePagerTitleView.setSelectedColor(Color.WHITE);
        simplePagerTitleView.setTextSize(17);
        simplePagerTitleView.setText(data.get(index).getCate_name());
        simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(index);
            }
        });
        return simplePagerTitleView;
    }

    @Override
    public IPagerIndicator getIndicator(Context context) {
        LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
        linePagerIndicator.setMode(LinePagerIndicator.MODE_EXACTLY);
        linePagerIndicator.setLineWidth(UIUtil.dip2px(context, 40));
        linePagerIndicator.setColors(Color.WHITE);
        return linePagerIndicator;
    }

}
