package com.sixin.ztv.home;

import android.view.View;
import android.widget.ImageView;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.gyf.barlibrary.ImmersionBar;
import com.sixin.ztv.R;
import com.sixin.ztv.base.BaseActivity;
import com.sixin.ztv.entertainment.EntertainmentFragment;
import com.sixin.ztv.find.FindFragment;
import com.sixin.ztv.fishbar.FishBarFragment;
import com.sixin.ztv.follow.FollowFragment;
import com.sixin.ztv.helper.BottomNavigationItemHelper;
import com.sixin.ztv.recommend.RecommendFragment;

import butterknife.BindView;
import butterknife.OnClick;

public class HomeActivity extends BaseActivity implements BottomNavigationBar.OnTabSelectedListener {
    //todo BaseActivity封装  BaseFragment的封装
    //todo 平板提供一个hd版本的
    //todo activity的跳转动画
    //todo 过度绘制
    //todo 集成Crash日志工具类
    //todo 剪切板工具类
    //todo 广告页面
    //todo Retrofit添加公共请求参数，提高代码复用
    //todo 面对开源项目中多个API如何进行封装的问题
    //todo 使用CardView
    @BindView(R.id.nvb_home)
    BottomNavigationBar mNavHome;

    @BindView(R.id.img_person)
    ImageView mImgPerson;

    @BindView(R.id.img_watching_history)
    ImageView mImgWatchingHistory;

    @BindView(R.id.img_mobile_games)
    ImageView mImgMobileGames;

    @BindView(R.id.img_im)
    ImageView mImgIm;

    private String tagRecommend;
    private String tagEntertainment;
    private String tagFollow;
    private String tagFishBar;
    private String tagFind;

    @OnClick({R.id.img_person, R.id.img_watching_history, R.id.img_mobile_games, R.id.img_im})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_person:
                break;
            case R.id.img_watching_history:
                break;
            case R.id.img_mobile_games:
                break;
            case R.id.img_im:
                break;
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void initImmersionBar() {
        ImmersionBar.with(this).titleBar(R.id.toolbar_home).init();
    }

    @Override
    protected void initView() {
        initFragmentTag();
        initBottomNavigationBar();
        setDefaultFragment();
    }

    private void setDefaultFragment() {
        addFragmentV4(RecommendFragment.newInstance(),tagRecommend,R.id.container);
    }

    private void initFragmentTag() {
        tagRecommend = getResources().getString(R.string.recommend_fragment_tag);
        tagEntertainment = getResources().getString(R.string.entertainment_fragment_tag);
        tagFollow = getResources().getString(R.string.follow_fragment_tag);
        tagFishBar = getResources().getString(R.string.fish_bar_fragment_tag);
        tagFind = getResources().getString(R.string.find_fragment_tag);
    }

    private void initBottomNavigationBar() {
        mNavHome.setBarBackgroundColor(R.color.colorNavBackground)
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)
                .setMode(BottomNavigationBar.MODE_FIXED)
                .addItem(new BottomNavigationItem(R.drawable.jiankong_selected,getString(R.string.recommend))
                        .setInactiveIconResource(R.drawable.jiankong)
                        .setActiveColorResource(R.color.colorNavItemActive)
                        .setInActiveColorResource(R.color.colorNavItemInActive))
                .addItem(new BottomNavigationItem(R.drawable.starfish_selected,getString(R.string.entertainment))
                        .setInactiveIconResource(R.drawable.starfish)
                        .setActiveColorResource(R.color.colorNavItemActive)
                        .setInActiveColorResource(R.color.colorNavItemInActive))
                .addItem(new BottomNavigationItem(R.drawable.love_selected,getString(R.string.follow))
                        .setInactiveIconResource(R.drawable.love)
                        .setActiveColorResource(R.color.colorNavItemActive)
                        .setInActiveColorResource(R.color.colorNavItemInActive))
                .addItem(new BottomNavigationItem(R.drawable.shangpin_selected,getString(R.string.fish_bar))
                        .setInactiveIconResource(R.drawable.shangpin)
                        .setActiveColorResource(R.color.colorNavItemActive)
                        .setInActiveColorResource(R.color.colorNavItemInActive))
                .addItem(new BottomNavigationItem(R.drawable.lingdang_selected,getString(R.string.find))
                        .setInactiveIconResource(R.drawable.lingdang)
                        .setActiveColorResource(R.color.colorNavItemActive)
                        .setInActiveColorResource(R.color.colorNavItemInActive))
                .setFirstSelectedPosition(0)
                .initialise();
        //todo 尺寸部分存在问题，需要适配
        BottomNavigationItemHelper.setBottomNavigationItem(mNavHome,8,26,12);
        mNavHome.setTabSelectedListener(this);
    }

    @Override
    public void onTabSelected(int position) {
        switch (position) {
            case 0:
                showOrAddFragment(tagRecommend, RecommendFragment.newInstance(),R.id.container);
                break;
            case 1:
                showOrAddFragment(tagEntertainment, EntertainmentFragment.newInstance(),R.id.container);
                break;
            case 2:
                showOrAddFragment(tagFollow, FollowFragment.newInstance(),R.id.container);
                break;
            case 3:
                showOrAddFragment(tagFishBar, FishBarFragment.newInstance(),R.id.container);
                break;
            case 4:
                showOrAddFragment(tagFind, FindFragment.newInstance(),R.id.container);
                break;
        }
    }

    @Override
    public void onTabUnselected(int position) {
    }

    @Override
    public void onTabReselected(int position) {
    }
}
