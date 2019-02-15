package com.sixin.ztv.recommend.channel.fragments.fragment8;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sixin.ztv.R;

public class LabelFragment8 extends Fragment {

    public LabelFragment8() {
        // Required empty public constructor
    }

    public static LabelFragment8 newInstance() {
        LabelFragment8 fragment = new LabelFragment8();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_label_fragment8, container, false);
    }

}
