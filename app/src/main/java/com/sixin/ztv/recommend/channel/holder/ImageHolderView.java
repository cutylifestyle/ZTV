package com.sixin.ztv.recommend.channel.holder;

import android.view.View;
import android.widget.ImageView;

import com.makeramen.roundedimageview.RoundedImageView;
import com.sixin.ztv.R;
import com.sixin.ztv.widget.convenientbanner.holder.Holder;

public class ImageHolderView extends Holder<String> {

    private RoundedImageView mImgView;

    public ImageHolderView(View itemView) {
        super(itemView);
    }

    @Override
    protected void initView(View itemView) {
        mImgView = itemView.findViewById(R.id.img_channel_banner);
    }

    @Override
    public void updateUI(String data) {

    }
}
