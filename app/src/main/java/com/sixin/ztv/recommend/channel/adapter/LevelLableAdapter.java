package com.sixin.ztv.recommend.channel.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;

import com.sixin.ztv.R;
import com.sixin.ztv.recommend.adapter.ScaleTransitionPagerTitleView;
import com.sixin.ztv.recommend.channel.fragments.fragment1.LabelFragment1;
import com.sixin.ztv.recommend.channel.fragments.fragment10.LabelFragment10;
import com.sixin.ztv.recommend.channel.fragments.fragment11.LabelFragment11;
import com.sixin.ztv.recommend.channel.fragments.fragment12.LabelFragment12;
import com.sixin.ztv.recommend.channel.fragments.fragment13.LabelFragment13;
import com.sixin.ztv.recommend.channel.fragments.fragment14.LabelFragment14;
import com.sixin.ztv.recommend.channel.fragments.fragment2.LabelFragment2;
import com.sixin.ztv.recommend.channel.fragments.fragment3.LabelFragment3;
import com.sixin.ztv.recommend.channel.fragments.fragment4.LabelFragment4;
import com.sixin.ztv.recommend.channel.fragments.fragment5.LabelFragment5;
import com.sixin.ztv.recommend.channel.fragments.fragment6.LabelFragment6;
import com.sixin.ztv.recommend.channel.fragments.fragment7.LabelFragment7;
import com.sixin.ztv.recommend.channel.fragments.fragment8.LabelFragment8;
import com.sixin.ztv.recommend.channel.fragments.fragment9.LabelFragment9;
import com.sixin.ztv.recommend.channel.model.bean.ChannelLevelLableBean;

import net.lucode.hackware.magicindicator.FragmentContainerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

import java.util.ArrayList;
import java.util.List;

public class LevelLableAdapter extends CommonNavigatorAdapter {
    private static final String TAG = "LevelLableAdapter";
    private List<ChannelLevelLableBean> data;
    private List<Fragment> mFragments = new ArrayList<>();
    private FragmentManager mFragmentManager;
    private FragmentContainerHelper mFragmentHelper;

    public LevelLableAdapter(List<ChannelLevelLableBean> data, FragmentManager fragmentManager, FragmentContainerHelper fragmentContainerHelper) {
        this.data = data;
        mFragmentManager = fragmentManager;
        mFragmentHelper = fragmentContainerHelper;
        initFragments();
    }

    private void initFragments() {
        if (data != null && data.size() > 0) {
            //todo 测试集合是空的情况
            for (ChannelLevelLableBean channelLevelLableBean : data) {
                int componentId = channelLevelLableBean.getComponent_id();
                switch (componentId) {
                    case 1:
                        mFragments.add(LabelFragment1.newInstance());
                        break;
                    case 2:
                        mFragments.add(LabelFragment2.newInstance());
                        break;
                    case 3:
                        mFragments.add(LabelFragment3.newInstance());
                        break;
                    case 4:
                        mFragments.add(LabelFragment4.newInstance());
                        break;
                    case 5:
                        mFragments.add(LabelFragment5.newInstance());
                        break;
                    case 6:
                        mFragments.add(LabelFragment6.newInstance());
                        break;
                    case 7:
                        mFragments.add(LabelFragment7.newInstance());
                        break;
                    case 8:
                        mFragments.add(LabelFragment8.newInstance());
                        break;
                    case 9:
                        mFragments.add(LabelFragment9.newInstance());
                        break;
                    case 10:
                        mFragments.add(LabelFragment10.newInstance());
                        break;
                    case 11:
                        mFragments.add(LabelFragment11.newInstance());
                        break;
                    case 12:
                        mFragments.add(LabelFragment12.newInstance());
                        break;
                    case 13:
                        mFragments.add(LabelFragment13.newInstance());
                        break;
                    case 14:
                        mFragments.add(LabelFragment14.newInstance());
                        break;
                }
            }
        }
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
        SimplePagerTitleView simplePagerTitleView = new TypefaceTransitionPagerTitleView(context);
        simplePagerTitleView.setNormalColor(Color.BLACK);
        simplePagerTitleView.setSelectedColor(Color.BLACK);
        simplePagerTitleView.setTextSize(15);
        simplePagerTitleView.setText(data.get(index).getTitle());
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
        Log.d(TAG, "mFragments:" + mFragments.toString());
        Fragment fragment;
        for (int i = 0, j = mFragments.size(); i < j; i++) {
            if (i == index) {
                continue;
            }
            fragment = mFragments.get(i);
            if (fragment.isAdded()) {
                Log.d(TAG, "111111111111");
                fragmentTransaction.hide(fragment);
            }
        }
        fragment = mFragments.get(index);
        if (fragment.isAdded()) {
            fragmentTransaction.show(fragment);
        } else {
            Log.d(TAG, "----------------");
            fragmentTransaction.add(R.id.fragment_container1, fragment);
        }
        fragmentTransaction.commitAllowingStateLoss();
    }

}
