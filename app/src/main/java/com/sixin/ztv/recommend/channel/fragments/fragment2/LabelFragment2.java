package com.sixin.ztv.recommend.channel.fragments.fragment2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sixin.ztv.R;


public class LabelFragment2 extends Fragment {

    public LabelFragment2() {
        // Required empty public constructor
    }

    public static LabelFragment2 newInstance() {
        LabelFragment2 fragment = new LabelFragment2();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lable_fragment2, container, false);
    }

}
