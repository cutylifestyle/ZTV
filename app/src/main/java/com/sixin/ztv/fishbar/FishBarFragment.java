package com.sixin.ztv.fishbar;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sixin.ztv.R;
import com.sixin.ztv.base.BaseFragment;
import com.sixin.ztv.utils.LogUtils;

public class FishBarFragment extends BaseFragment {

    public FishBarFragment() {
        // Required empty public constructor
    }

    public static FishBarFragment newInstance() {
        FishBarFragment fragment = new FishBarFragment();
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_fish_bar;
    }

}
