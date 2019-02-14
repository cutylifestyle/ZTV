package com.sixin.ztv.recommend.channel.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;

import com.sixin.ztv.recommend.adapter.ScaleTransitionPagerTitleView;
import com.sixin.ztv.recommend.channel.model.bean.ChannelLevelLableBean;

import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

import java.util.List;

public class LevelLableAdapter extends CommonNavigatorAdapter {

    private List<ChannelLevelLableBean> data;

    public LevelLableAdapter(List<ChannelLevelLableBean> data) {
        this.data = data;
    }

    @Override
    public int getCount() {
        return data == null ? 0 :data.size();
    }

    public void setData(List<ChannelLevelLableBean> data) {
        this.data = data;
    }

    @Override
    public IPagerTitleView getTitleView(Context context, final int index) {
        SimplePagerTitleView simplePagerTitleView = new ScaleTransitionPagerTitleView(context);
        simplePagerTitleView.setNormalColor(Color.WHITE);
        simplePagerTitleView.setSelectedColor(Color.WHITE);
        simplePagerTitleView.setTextSize(17);
        simplePagerTitleView.setText(data.get(index).getTitle());
        simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return simplePagerTitleView;
    }

    @Override
    public IPagerIndicator getIndicator(Context context) {
//        LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
//        linePagerIndicator.setMode(LinePagerIndicator.MODE_EXACTLY);
//        linePagerIndicator.setLineWidth(UIUtil.dip2px(context, 40));
//        linePagerIndicator.setColors(Color.WHITE);
        return null;
    }

}
