package com.chengyu.qxapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.chengyu.qxapp.Adapter.SectionsPagerAdapter;
import com.chengyu.qxapp.fragment.FragmentChat;
import com.chengyu.qxapp.fragment.FragmentHome;
import com.chengyu.qxapp.fragment.FragmentMine;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener, ViewPager.OnPageChangeListener {

    private ViewPager viewPager;
    private BottomNavigationBar bottomNavigationBar;
    private List<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager.findViewById(R.id.viewPager);
        bottomNavigationBar = findViewById(R.id.bottom);

        initView();
    }

    private void initView() {
        initViewPage();
        initBottomNavigation();

    }

    private void initBottomNavigation() {
        bottomNavigationBar.setTabSelectedListener(this);
        bottomNavigationBar.clearAll();
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);  //自适应大小
        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_DEFAULT);
        bottomNavigationBar.setBarBackgroundColor(R.color.white).setActiveColor(R.color.colorBase1).setInActiveColor(R.color.black);


        bottomNavigationBar.addItem(new BottomNavigationItem((R.drawable.homepage_fill), "首页").setInactiveIconResource(R.drawable.homepage))
                .addItem(new BottomNavigationItem((R.drawable.mobilephone_fill), "论坛").setInactiveIconResource(R.drawable.mobilephone))
                .addItem(new BottomNavigationItem((R.drawable.mine_fill), "我的").setInactiveIconResource(R.drawable.mine))
                .setFirstSelectedPosition(0)
                .initialise();
    }

    private void initViewPage() {
        viewPager.setOffscreenPageLimit(3); //缓存3个

        fragments = new ArrayList<Fragment>();

        fragments.add(new FragmentHome());
        fragments.add(new FragmentChat());
        fragments.add(new FragmentMine());

        viewPager.setAdapter(new SectionsPagerAdapter(getSupportFragmentManager(), fragments));
        viewPager.addOnPageChangeListener(this);
        viewPager.setCurrentItem(0);


    }

    /****** ** BottomNavigationBarListener ** *****/
    @Override
    public void onTabSelected(int position) {

    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
/****** ** ViewPager.OnPageChangeListener  ** *****/
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

}
