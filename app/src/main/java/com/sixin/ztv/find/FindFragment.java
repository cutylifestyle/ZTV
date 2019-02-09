package com.sixin.ztv.find;

import com.sixin.ztv.R;
import com.sixin.ztv.base.BaseFragment;
import com.sixin.ztv.utils.LogUtils;

public class FindFragment extends BaseFragment {

    public FindFragment() {
        // Required empty public constructor
    }


    public static FindFragment newInstance() {
        FindFragment fragment = new FindFragment();
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_find;
    }

}
