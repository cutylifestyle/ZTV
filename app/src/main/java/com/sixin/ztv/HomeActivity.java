package com.sixin.ztv;

import android.view.View;
import android.widget.ImageView;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.gyf.barlibrary.ImmersionBar;
import com.sixin.ztv.base.BaseActivity;
import com.sixin.ztv.helper.BottomNavigationItemHelper;
import butterknife.BindView;
import butterknife.OnClick;

public class HomeActivity extends BaseActivity implements BottomNavigationBar.OnTabSelectedListener {
    //todo BaseActivity封装
    //todo BaseMvpActivity封装
    //todo 平板提供一个hd版本的    采用mvp   rxjava的架构模式
    //todo activity的跳转动画  BaseFragment的封装
    //todo 过度绘制
    //todo 集成Crash日志工具类
    //todo 剪切板工具类
    //todo 首页界面
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
        initBottomNavigationBar();
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
                .initialise();
        //todo 尺寸部分存在问题，需要适配
        BottomNavigationItemHelper.setBottomNavigationItem(mNavHome,8,26,12);

        mNavHome.setTabSelectedListener(this);
    }

    @Override
    public void onTabSelected(int position) {

    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}
