package com.database.madhusoodhan.sportsnews.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.database.madhusoodhan.sportsnews.CommentaryFragment;
import com.database.madhusoodhan.sportsnews.ScoreFragment;
import com.database.madhusoodhan.sportsnews.TimetableFragment;

/**
 * Created by madhusoodhan on 18-Mar-15.
 */
public class TabsPagerAdapter extends FragmentPagerAdapter {

    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int index) {

        switch (index){
            case 0: return new TimetableFragment();

            case 1: return new ScoreFragment();

            case 2: return new CommentaryFragment();
        }

        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
