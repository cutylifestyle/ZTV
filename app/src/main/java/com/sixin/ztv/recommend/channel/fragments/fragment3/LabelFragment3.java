package com.sixin.ztv.recommend.channel.fragments.fragment3;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sixin.ztv.R;

public class LabelFragment3 extends Fragment {

    public LabelFragment3() {
        // Required empty public constructor
    }

    public static LabelFragment3 newInstance() {
        LabelFragment3 fragment = new LabelFragment3();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_label_fragment3, container, false);
    }

}
