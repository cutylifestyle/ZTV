package com.sixin.ztv.recommend.adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.sixin.ztv.recommend.channel.ChannelFragment;
import com.sixin.ztv.recommend.model.bean.RecommendChannelBean;

import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private List<RecommendChannelBean> mDataList;
    private FragmentManager mFragmentManager;

    public ViewPagerAdapter(FragmentManager fm,List<RecommendChannelBean> dataList) {
        super(fm);
        mDataList = dataList;
        mFragmentManager = fm;
    }

    @Override
    public Fragment getItem(int i) {
        return ChannelFragment.newInstance(mDataList.get(i));
    }

    @Override
    public int getCount() {
        return mDataList == null ? 0 : mDataList.size();
    }

    public void setData(List<RecommendChannelBean> dataList) {
        mDataList = dataList;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        Fragment fragment = (Fragment) super.instantiateItem(container, position);
        mFragmentManager.beginTransaction().show(fragment).commit();
        return fragment;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//        super.destroyItem(container, position, object);
        if(object instanceof Fragment){
            mFragmentManager.beginTransaction().hide((Fragment) object).commit();
        }
    }
}
