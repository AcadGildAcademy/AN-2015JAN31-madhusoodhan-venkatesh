package com.database.madhusoodhan.sportsnews;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar.TabListener;


import com.database.madhusoodhan.sportsnews.Adapter.TabsPagerAdapter;

/**
 * Created by madhusoodhan on 18-Mar-15.
 */
public class NewsActivity extends FragmentActivity implements TabListener,ViewPager.OnPageChangeListener {

    private ViewPager viewPager;
    private TabsPagerAdapter adapter;
    private ActionBar actionBar;

    private String[] Tabs = {"Timetable" , "Score","Commentary"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);

        viewPager = (ViewPager)findViewById(R.id.view_pager);
        actionBar = getActionBar();
        adapter = new TabsPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(adapter);
        actionBar.setHomeButtonEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);

        for(String tabName : Tabs){
            actionBar.addTab(actionBar.newTab().setText(tabName).setTabListener(this));

        }

        viewPager.setOnPageChangeListener(this);
    }

    @Override
    public void onTabSelected(android.support.v7.app.ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }


    @Override
    public void onTabUnselected(android.support.v7.app.ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabReselected(android.support.v7.app.ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onPageScrolled(int i, float v, int i2) {

    }

    @Override
    public void onPageSelected(int i) {

    }
}
