package com.sixin.ztv.recommend.channel.fragments.fragment11.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;

import com.sixin.ztv.R;
import com.sixin.ztv.widget.BgTransitionPagerTitleView;
import com.sixin.ztv.widget.TypefaceTransitionPagerTitleView;
import com.sixin.ztv.recommend.channel.fragments.fragment11.livepreview.LivePreviewFragment;
import com.sixin.ztv.recommend.channel.fragments.fragment11.model.bean.SubLabelBean;

import net.lucode.hackware.magicindicator.FragmentContainerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

import java.util.ArrayList;
import java.util.List;
//todo 该adapter与labelAdapter重复，尝试封装
public class SubLabelAdapter extends CommonNavigatorAdapter {
    private List<SubLabelBean> data;
    private List<Fragment> mFragments = new ArrayList<>();
    private FragmentManager mFragmentManager;
    private FragmentContainerHelper mFragmentHelper;

    public SubLabelAdapter(List<SubLabelBean> data, FragmentManager fragmentManager, FragmentContainerHelper fragmentContainerHelper) {
        this.data = data;
        mFragmentManager = fragmentManager;
        mFragmentHelper = fragmentContainerHelper;
        initFragments();
    }

    private void initFragments() {
        if (data != null && data.size() > 0) {
            //todo 测试集合是空的情况
            for (SubLabelBean subLabelBean : data) {
                mFragments.add(LivePreviewFragment.newInstance(subLabelBean));
            }
        }
    }

    @Override
    public int getCount() {
        return data == null ? 0 :data.size();
    }

    public void setData(List<SubLabelBean> data) {
        this.data = data;
    }

    @Override
    public IPagerTitleView getTitleView(Context context, final int index) {
        SimplePagerTitleView simplePagerTitleView = new BgTransitionPagerTitleView(context);
        simplePagerTitleView.setNormalColor(R.color.colorNormalSubLabelTv);
//        simplePagerTitleView.setSelectedColor(R.color.colorSelectSubLabelTv);
        simplePagerTitleView.setTextSize(13);
        simplePagerTitleView.setText(data.get(index).getName());
        simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFragmentHelper.handlePageSelected(index);
                switchPages(index);
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

    public void switchPages(int index) {
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        Fragment fragment;
        for (int i = 0, j = mFragments.size(); i < j; i++) {
            if (i == index) {
                continue;
            }
            fragment = mFragments.get(i);
            if (fragment.isAdded()) {
                fragmentTransaction.hide(fragment);
            }
        }
        fragment = mFragments.get(index);
        if (fragment.isAdded()) {
            fragmentTransaction.show(fragment);
        } else {
            fragmentTransaction.add(R.id.fragment_container, fragment);
        }
        fragmentTransaction.commitAllowingStateLoss();
    }

}
