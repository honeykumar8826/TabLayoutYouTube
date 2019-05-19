package com.tab;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.tab.fragment.HomeFragment;
import com.tab.fragment.InboxFragment;
import com.tab.fragment.LibraryFragment;
import com.tab.fragment.SubscriptionsFragment;
import com.tab.fragment.TrendingFragment;


public class PageAdapter extends FragmentPagerAdapter {
    private int tabNum;
    public static String TAG ="Adapter";
    public PageAdapter(FragmentManager fm, int tabNum) {
        super(fm);
        this.tabNum = tabNum;
    }
    @Override
    public Fragment getItem(int position) {
        Log.i(TAG, "getItem: ");
        switch (position)
        {
            case 0: return new HomeFragment();
            case 1: return new TrendingFragment();
            case 2: return new SubscriptionsFragment();
            case 3: return new InboxFragment();
            case 4: return new LibraryFragment();
            default:return  null;
        }
    }
    @Override
    public int getCount() {
        Log.i(TAG, "getCount: ");
        return tabNum;
    }
}
