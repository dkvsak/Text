package com.ep.jyq.design;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Joy on 2015/7/16.
 */
public class VpAdapter extends FragmentPagerAdapter {
     private  List<Fragment> mList ;
    private List<String> mTitles;
    public VpAdapter(FragmentManager fm, List<Fragment> mList, List<String> mTitles) {
        super(fm);
         this.mList=mList;
        this.mTitles=mTitles;
    }


    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }


}
