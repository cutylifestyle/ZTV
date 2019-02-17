package com.sixin.ztv.widget;

import android.content.Context;
import android.graphics.Typeface;

import com.sixin.ztv.R;

import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;

/**
 * 带颜色渐变和缩放的指示器标题
 * 博客: http://hackware.lucode.net
 * Created by hackware on 2016/6/26.
 */
public class BgTransitionPagerTitleView extends ColorTransitionPagerTitleView {

    public BgTransitionPagerTitleView(Context context) {
        super(context);
    }

    @Override
    public void onEnter(int index, int totalCount, float enterPercent, boolean leftToRight) {
        super.onEnter(index, totalCount, enterPercent, leftToRight);    // 实现颜色渐变
        setBackgroundResource(R.drawable.shape_select_sub_label);
        setTextColor(getResources().getColor(R.color.colorSelectSubLabelTv));
    }

    @Override
    public void onLeave(int index, int totalCount, float leavePercent, boolean leftToRight) {
        super.onLeave(index, totalCount, leavePercent, leftToRight);    // 实现颜色渐变
        setBackgroundResource(R.drawable.shape_unselect_sub_label);
        setTextColor(getResources().getColor(R.color.colorNormalSubLabelTv));
    }

}
