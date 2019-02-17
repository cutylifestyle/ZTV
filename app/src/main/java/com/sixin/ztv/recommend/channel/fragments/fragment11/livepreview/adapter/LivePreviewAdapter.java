package com.sixin.ztv.recommend.channel.fragments.fragment11.livepreview.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.sixin.ztv.R;
import com.sixin.ztv.recommend.channel.fragments.fragment11.livepreview.model.bean.LivePreviewBean;
import com.sixin.ztv.utils.Utils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LivePreviewAdapter extends BaseQuickAdapter<LivePreviewBean.ListBean, LivePreviewAdapter.LivePreviewHolder> {

    public LivePreviewAdapter(int layoutResId, @Nullable List<LivePreviewBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(LivePreviewHolder helper, LivePreviewBean.ListBean item) {
        //todo 这段代码with中的内容可能存在问题泄漏问题  错误图片，内存上涨等等
        //todo 完善内容提示
        Glide.with(Utils.getApp()).load(item.getRoom_src()).into(helper.mImgRoom);
        helper.mTvUpName.setText(item.getNickname());
        helper.mTvRoomTitle.setText(item.getRoom_name());
        //todo 注意这个部分如果没有数据，需要影藏控件
        //todo 数据进行换算
        helper.mTvUpHot.setText(item.getHn()+"");
    }

    class LivePreviewHolder extends BaseViewHolder{
        //todo 这块的绑定是否需要释放
        @BindView(R.id.img_room)
        ImageView mImgRoom;

        @BindView(R.id.tv_room_title)
        TextView mTvRoomTitle;

        @BindView(R.id.tv_up_name)
        TextView mTvUpName;

        @BindView(R.id.tv_up_hot)
        TextView mTvUpHot;

       public LivePreviewHolder(View view) {
           super(view);
           ButterKnife.bind(this,view);
       }
   }
}
