package com.sixin.ztv.recommend.channel.fragments.fragment12;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sixin.ztv.R;

public class LabelFragment12 extends Fragment {

    public LabelFragment12() {
        // Required empty public constructor
    }

    public static LabelFragment12 newInstance() {
        LabelFragment12 fragment = new LabelFragment12();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_label_fragment12, container, false);
    }

}
