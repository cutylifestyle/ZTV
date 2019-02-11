package com.sixin.ztv.recommend.channel.holder;

import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.makeramen.roundedimageview.RoundedImageView;
import com.sixin.ztv.R;
import com.sixin.ztv.recommend.channel.model.bean.ChannelBannerBean;
import com.sixin.ztv.utils.Utils;
import com.sixin.ztv.widget.convenientbanner.holder.Holder;

public class ImageHolderView extends Holder<ChannelBannerBean> {

    private RoundedImageView mImgView;
    private TextView mTvChannelBanner;

    public ImageHolderView(View itemView) {
        super(itemView);
    }

    @Override
    protected void initView(View itemView) {
        //TODO mImgView设置默认空试图
        mImgView = itemView.findViewById(R.id.img_channel_banner);
        mTvChannelBanner = itemView.findViewById(R.id.tv_channel_banner);
    }

    @Override
    public void updateUI(ChannelBannerBean data) {
        if (data != null) {
            //todo 添加错误图片  空图片   对图片进行压缩处理
            Glide.with(Utils.getApp()).load(data.getSrcid()).into(mImgView);
            mTvChannelBanner.setText(data.getAdtitle());
        }
    }

}
