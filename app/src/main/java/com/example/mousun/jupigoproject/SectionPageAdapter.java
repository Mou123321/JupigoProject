package com.example.mousun.jupigoproject;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mousun on 10/25/17.
 */

/*
 *  This custom adapter extends the more general FragmentStatePagerAdapter
 *  This class helps create the ViewPager which can handle all the events of
 *      swipe tabs
 */
public class SectionPageAdapter extends FragmentStatePagerAdapter {

    private final List<Fragment> mFrangmentList = new ArrayList<>();
    private final List<String> mFrangmentTitleList = new ArrayList<>();

    public void addFragment(Fragment fragment, String title){
        mFrangmentList.add(fragment);
        mFrangmentTitleList.add(title);
    }

    public SectionPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFrangmentTitleList.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return mFrangmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFrangmentList.size();
    }
}