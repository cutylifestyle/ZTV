package com.sixin.ztv.recommend.channel.fragments.fragment14.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.sixin.ztv.R;
import com.sixin.ztv.recommend.channel.fragments.fragment14.model.bean.MatchBean;
import com.sixin.ztv.utils.TimeUtils;
import com.sixin.ztv.utils.Utils;

import java.text.SimpleDateFormat;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MatchAdapter extends BaseQuickAdapter<MatchBean, MatchAdapter.MatchViewHolder> {

    public MatchAdapter(int layoutResId, @Nullable List<MatchBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(MatchViewHolder helper, MatchBean item) {
        Glide.with(Utils.getApp()).load(item.getTeam1_logo()).into(helper.imgTeam1);
        Glide.with(Utils.getApp()).load(item.getTeam2_logo()).into(helper.imgTeam2);
        helper.tvTeam1Name.setText(item.getTeam1_name());
        helper.tvTeam2Name.setText(item.getTeam2_name());
        helper.tvMatchTime.setText(TimeUtils.millis2String(item.getBegin_time()*1000L,new SimpleDateFormat("MM/dd HH:mm")) + " " + item.getMatch_name());
        helper.tvScore.setText(item.getScore()==null?"VS":item.getScore());
        int resId = -1;
        switch (item.getStatus()) {
            case 1:
                resId = R.drawable.ic_order_live;
                break;
            case 2:
                resId = R.drawable.ic_watch_live;
                break;
            case 3:
                resId = R.drawable.ic_watch_vedio;
                break;
        }
        helper.imgVideoType.setImageResource(resId);
    }

    class MatchViewHolder extends BaseViewHolder{

        @BindView(R.id.img_team1_logo)
        ImageView imgTeam1;

        @BindView(R.id.img_team2_logo)
        ImageView imgTeam2;

        @BindView(R.id.tv_team1_name)
        TextView tvTeam1Name;

        @BindView(R.id.tv_team2_name)
        TextView tvTeam2Name;

        @BindView(R.id.tv_match_time)
        TextView tvMatchTime;

        @BindView(R.id.tv_score)
        TextView tvScore;

        @BindView(R.id.img_match_video_type)
        ImageView imgVideoType;

        public MatchViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
