package com.sixin.ztv.recommend.channel.fragments.fragment11;

import com.sixin.ztv.Http.response.ResponseListener;
import com.sixin.ztv.base.RxPresenter;
import com.sixin.ztv.recommend.channel.fragments.fragment11.model.Fragment11DataManager;
import com.sixin.ztv.recommend.channel.fragments.fragment11.model.Fragment11Model;
import com.sixin.ztv.recommend.channel.fragments.fragment11.model.bean.SubLabelBean;
import com.sixin.ztv.recommend.channel.model.bean.ChannelLevelLableBean;
import com.sixin.ztv.utils.LogUtils;

import java.util.List;

public class Fragment11Presenter extends RxPresenter<Fragment11Contract.View> implements Fragment11Contract.Presenter {

    private Fragment11Model mFragment11Model;

    public Fragment11Presenter(Fragment11Contract.View view) {
        super(view);
        mFragment11Model = new Fragment11DataManager();
    }

    @Override
    public void loadSubLabel(ChannelLevelLableBean channelLevelLableBean) {
        if (channelLevelLableBean != null) {
            addSubscribe(mFragment11Model.loadSubLabels(channelLevelLableBean.getCate2_id(), new ResponseListener<List<SubLabelBean>>() {
                @Override
                public void onSuccess(List<SubLabelBean> subLabelBeans) {
                    //todo 数据的判空能不能前置完成
                    if (subLabelBeans != null && subLabelBeans.size() > 0 && mView != null && mView.isActive()) {
                        mView.showSubLabel(subLabelBeans);
                    }
                    //todo else if的处理
                }

                @Override
                public void onFailure(Throwable t) {

                }

                @Override
                public void onFinish() {

                }
            }));
        }else{
            //todo 待处理
        }
    }
}
