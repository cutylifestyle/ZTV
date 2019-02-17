package com.sixin.ztv.recommend.channel.fragments.fragment11.livepreview;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.sixin.ztv.R;
import com.sixin.ztv.base.BaseFragment;
import com.sixin.ztv.base.BaseMvpFragment;
import com.sixin.ztv.recommend.channel.fragments.fragment11.livepreview.adapter.LivePreviewAdapter;
import com.sixin.ztv.recommend.channel.fragments.fragment11.livepreview.model.bean.LivePreviewBean;
import com.sixin.ztv.recommend.channel.fragments.fragment11.model.bean.SubLabelBean;

import java.util.List;

import butterknife.BindView;


public class LivePreviewFragment extends BaseMvpFragment<LivePreviewContract.Presenter> implements LivePreviewContract.View {

    @BindView(R.id.srl_live_preview)
    SmartRefreshLayout mSrlLivePreview;

    @BindView(R.id.rlv_live_preview)
    RecyclerView mRlvLivePreview;

    private LivePreviewAdapter mLivePreviewAdapter;

    public LivePreviewFragment() {
        // Required empty public constructor
    }

    public static LivePreviewFragment newInstance(SubLabelBean subLabelBean) {
        LivePreviewFragment fragment = new LivePreviewFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(SubLabelBean.class.getSimpleName(),subLabelBean);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_live_preview;
    }

    @Override
    protected void initView() {
        initRecyclerView();
    }

    private void initRecyclerView() {
        mRlvLivePreview.setLayoutManager(new GridLayoutManager(getContext(),2));
        mLivePreviewAdapter = new LivePreviewAdapter(R.layout.item_live_preview, null);
        mRlvLivePreview.setAdapter(mLivePreviewAdapter);
    }

    @Override
    protected void loadData() {
        mPresenter.loadLivePreviewInfo(getArguments()!= null? (SubLabelBean) getArguments().getSerializable(SubLabelBean.class.getSimpleName()) :null);
    }

    @Override
    protected LivePreviewContract.Presenter initPresenter() {
        return new LivePreviewPresenter(this);
    }

    @Override
    public boolean isActive() {
        //todo 这个部分需要修改
        return true;
    }

    @Override
    public void showLivePreviewInfo(List<LivePreviewBean.ListBean> listBeans) {
        if (listBeans != null && listBeans.size() > 0) {
            mLivePreviewAdapter.addData(listBeans);
        }else{

        }
    }
}
