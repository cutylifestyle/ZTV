package com.sixin.ztv.recommend.channel.fragments.fragment5;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sixin.ztv.R;

public class LabelFragment5 extends Fragment {


    public LabelFragment5() {
        // Required empty public constructor
    }

    public static LabelFragment5 newInstance() {
        LabelFragment5 fragment = new LabelFragment5();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_label_fragment5, container, false);
    }

}
