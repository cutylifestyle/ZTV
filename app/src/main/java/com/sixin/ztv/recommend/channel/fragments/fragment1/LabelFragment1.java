package com.sixin.ztv.recommend.channel.fragments.fragment1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sixin.ztv.R;

public class LabelFragment1 extends Fragment {


    public LabelFragment1() {
        // Required empty public constructor
    }

    public static LabelFragment1 newInstance() {
        LabelFragment1 fragment = new LabelFragment1();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_label_fragment1, container, false);
    }

}
