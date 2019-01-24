package com.sixin.ztv;

import android.os.Bundle;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.sixin.ztv.base.BaseMvpActivity;
import com.sixin.ztv.helper.BottomNavigationItemHelper;
import butterknife.BindView;

public class HomeActivity extends BaseMvpActivity implements BottomNavigationBar.OnTabSelectedListener {
    //todo BaseActivity封装    BaseFragment的封装   手机屏幕适配
    //todo 平板提供一个hd版本的    采用mvp   rxjava的架构模式
    //todo activity的跳转动画   通用toolbar  集成内存泄漏工具  数据库监测工具
    @BindView(R.id.nvb_home)
    BottomNavigationBar mNavHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

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
