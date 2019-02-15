package com.sixin.ztv.recommend.channel.fragments.fragment11;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sixin.ztv.R;

public class LabelFragment11 extends Fragment {

    public LabelFragment11() {
        // Required empty public constructor
    }

    public static LabelFragment11 newInstance() {
        LabelFragment11 fragment = new LabelFragment11();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_label_fragment11, container, false);
    }

}
