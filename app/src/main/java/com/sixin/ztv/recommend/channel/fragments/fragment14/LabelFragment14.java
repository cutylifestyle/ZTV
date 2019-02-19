package com.sixin.ztv.recommend.channel.fragments.fragment14;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sixin.ztv.R;
import com.sixin.ztv.base.BaseFragment;
import com.sixin.ztv.base.BaseMvpFragment;
import com.sixin.ztv.recommend.channel.fragments.fragment14.adapter.MatchAdapter;
import com.sixin.ztv.recommend.channel.fragments.fragment14.model.bean.MatchBean;
import com.sixin.ztv.recommend.channel.model.bean.ChannelLevelLableBean;

import java.util.List;

import butterknife.BindView;

public class LabelFragment14 extends BaseMvpFragment<MatchConstract.Presenter> implements MatchConstract.View {

    @BindView(R.id.rlv_match)
    RecyclerView mRlvMatch;

    private MatchAdapter mMatchAdapter;

    public LabelFragment14() {
        // Required empty public constructor
    }

    public static LabelFragment14 newInstance(ChannelLevelLableBean channelLevelLableBean) {
        LabelFragment14 fragment = new LabelFragment14();
        Bundle bundle = new Bundle();
        bundle.putSerializable(ChannelLevelLableBean.class.getSimpleName(), channelLevelLableBean);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_label_fragment14;
    }

    @Override
    protected void initView() {
        mRlvMatch.setLayoutManager(new LinearLayoutManager(getContext()));
        mMatchAdapter = new MatchAdapter(R.layout.item_match, null);
        mRlvMatch.setAdapter(mMatchAdapter);
    }

    @Override
    protected MatchConstract.Presenter initPresenter() {
        return new MatchPresenter(this);
    }

    @Override
    protected void loadData() {
        mPresenter.getMatchInfo(getArguments() != null? (ChannelLevelLableBean) getArguments().getSerializable(ChannelLevelLableBean.class.getSimpleName()) :null);
    }

    @Override
    public void showMatchInfo(List<MatchBean> matchBeans) {
        if (matchBeans != null && matchBeans.size() > 0) {
            mMatchAdapter.addData(matchBeans);
        }
        //todo 待处理
    }

    @Override
    public boolean isActive() {
        //todo 待处理
        return true;
    }
}
