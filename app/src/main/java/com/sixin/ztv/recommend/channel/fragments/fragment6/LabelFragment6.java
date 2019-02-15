package com.sixin.ztv.recommend.channel.fragments.fragment6;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sixin.ztv.R;

public class LabelFragment6 extends Fragment {

    public LabelFragment6() {
        // Required empty public constructor
    }

    public static LabelFragment6 newInstance() {
        LabelFragment6 fragment = new LabelFragment6();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_label_fragment6, container, false);
    }

}
