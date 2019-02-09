package com.sixin.ztv.follow;


import com.sixin.ztv.R;
import com.sixin.ztv.base.BaseFragment;
import com.sixin.ztv.utils.LogUtils;

public class FollowFragment extends BaseFragment {

    public FollowFragment() {
        // Required empty public constructor
    }

    public static FollowFragment newInstance() {
        FollowFragment fragment = new FollowFragment();
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_follow;
    }

}
