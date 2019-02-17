package com.sixin.ztv.recommend.channel.fragments.fragment11;


import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.sixin.ztv.R;
import com.sixin.ztv.base.BaseFragment;
import com.sixin.ztv.base.BaseMvpFragment;
import com.sixin.ztv.recommend.channel.adapter.LevelLableAdapter;
import com.sixin.ztv.recommend.channel.fragments.fragment11.adapter.SubLabelAdapter;
import com.sixin.ztv.recommend.channel.fragments.fragment11.model.bean.SubLabelBean;
import com.sixin.ztv.recommend.channel.model.bean.ChannelLevelLableBean;

import net.lucode.hackware.magicindicator.FragmentContainerHelper;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;

import java.util.List;

import butterknife.BindView;

public class LabelFragment11 extends BaseMvpFragment<Fragment11Contract.Presenter> implements Fragment11Contract.View {

    @BindView(R.id.indicator_sub_label)
    MagicIndicator mIndicatorSubLable;

    public LabelFragment11() {
        // Required empty public constructor
    }

    public static LabelFragment11 newInstance(ChannelLevelLableBean channelLevelLableBean) {
        LabelFragment11 fragment = new LabelFragment11();
        Bundle bundle = new Bundle();
        bundle.putSerializable(ChannelLevelLableBean.class.getSimpleName(),channelLevelLableBean);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_label_fragment11;
    }

    @Override
    protected Fragment11Contract.Presenter initPresenter() {
        return new Fragment11Presenter(this);
    }

    @Override
    protected void loadData() {
        mPresenter.loadSubLabel(getArguments()!=null? (ChannelLevelLableBean) getArguments().getSerializable(ChannelLevelLableBean.class.getSimpleName()) :null);
    }



    @Override
    public boolean isActive() {
        //todo 这个地方需要整改
        return true;
    }

    @Override
    public void showSubLabel(List<SubLabelBean> subLabelBeans) {
        if (subLabelBeans != null && subLabelBeans.size() > 0) {
            FragmentContainerHelper fragmentContainerHelper = new FragmentContainerHelper();
            CommonNavigator commonNavigator = new CommonNavigator(getContext());
            SubLabelAdapter subLabelAdapter = new SubLabelAdapter(subLabelBeans,getChildFragmentManager(),fragmentContainerHelper);
            commonNavigator.setAdapter(subLabelAdapter);
            mIndicatorSubLable.setNavigator(commonNavigator);
            LinearLayout titleContainer = commonNavigator.getTitleContainer(); // must after setNavigator
            titleContainer.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
            titleContainer.setDividerDrawable(new ColorDrawable() {
                @Override
                public int getIntrinsicWidth() {
                    return UIUtil.dip2px(getContext(), 10);
                }
            });
            fragmentContainerHelper.attachMagicIndicator(mIndicatorSubLable);

            fragmentContainerHelper.handlePageSelected(0,false);
            subLabelAdapter.switchPages(0);
        }else{
            //todo 待处理
        }
    }
}
