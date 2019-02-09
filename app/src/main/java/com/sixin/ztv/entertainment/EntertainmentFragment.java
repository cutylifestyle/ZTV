package com.sixin.ztv.entertainment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sixin.ztv.R;
import com.sixin.ztv.base.BaseFragment;
import com.sixin.ztv.utils.LogUtils;

public class EntertainmentFragment extends BaseFragment {

    public EntertainmentFragment() {
        // Required empty public constructor
    }

    public static EntertainmentFragment newInstance() {
        EntertainmentFragment fragment = new EntertainmentFragment();
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_entertainment;
    }

}
