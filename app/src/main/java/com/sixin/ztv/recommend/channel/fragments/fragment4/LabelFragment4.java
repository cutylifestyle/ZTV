package com.sixin.ztv.recommend.channel.fragments.fragment4;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sixin.ztv.R;

public class LabelFragment4 extends Fragment {

    public LabelFragment4() {
        // Required empty public constructor
    }

    public static LabelFragment4 newInstance() {
        LabelFragment4 fragment = new LabelFragment4();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_label_fragment4, container, false);
    }

}
