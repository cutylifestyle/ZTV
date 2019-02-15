package com.sixin.ztv.recommend.channel.fragments.fragment7;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sixin.ztv.R;

public class LabelFragment7 extends Fragment {

    public LabelFragment7() {
        // Required empty public constructor
    }

    public static LabelFragment7 newInstance() {
        LabelFragment7 fragment = new LabelFragment7();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_label_fragment7, container, false);
    }

}
