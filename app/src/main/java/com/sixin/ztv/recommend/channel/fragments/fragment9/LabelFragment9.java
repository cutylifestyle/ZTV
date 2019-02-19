package com.sixin.ztv.recommend.channel.fragments.fragment9;


import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.sixin.ztv.R;
import com.sixin.ztv.base.BaseFragment;
import com.sixin.ztv.recommend.channel.model.bean.ChannelLevelLableBean;

import butterknife.BindView;

public class LabelFragment9 extends BaseFragment {

    @BindView(R.id.srl_video)
    SmartRefreshLayout mSrlVideo;

    @BindView(R.id.rlv_video)
    RecyclerView mRlvVideo;

    public LabelFragment9() {
        // Required empty public constructor
    }

    public static LabelFragment9 newInstance(ChannelLevelLableBean channelLevelLableBean) {
        LabelFragment9 fragment = new LabelFragment9();
        Bundle bundle = new Bundle();
        bundle.putSerializable(ChannelLevelLableBean.class.getSimpleName(), channelLevelLableBean);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_label_fragment9;
    }

    @Override
    protected void initView() {
    }

    @Override
    protected void loadData() {

    }
}
