package com.sixin.ztv.recommend.channel.fragments.fragment10;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sixin.ztv.R;

public class LabelFragment10 extends Fragment {

    public LabelFragment10() {
        // Required empty public constructor
    }

    public static LabelFragment10 newInstance() {
        LabelFragment10 fragment = new LabelFragment10();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_label_fragment10, container, false);
    }

}
