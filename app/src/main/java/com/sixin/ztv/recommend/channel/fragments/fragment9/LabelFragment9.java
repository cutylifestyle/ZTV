package com.sixin.ztv.recommend.channel.fragments.fragment9;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sixin.ztv.R;

public class LabelFragment9 extends Fragment {

    public LabelFragment9() {
        // Required empty public constructor
    }

    public static LabelFragment9 newInstance() {
        LabelFragment9 fragment = new LabelFragment9();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_label_fragment9, container, false);
    }

}
