package com.example.android.tourguide.adapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private List<String> screenTitles;
    private List<Fragment> fragmentList;
    private Bundle bundle;

    public ViewPagerAdapter(FragmentManager fm, List<Fragment> fragmentList, List<String> screenTitles, Bundle bundle) {
        super(fm);
        this.bundle = bundle;
        this.fragmentList = fragmentList;
        this.screenTitles = screenTitles;
    }

    public Bundle getBundle() {
        return bundle;
    }

    public void setBundle(Bundle bundle) {
        this.bundle = bundle;
    }

    @Override
    public Fragment getItem(int i) {
        if (fragmentList.size() > 0) {
            updateFragment(fragmentList.get(i), bundle);
            return fragmentList.get(i);
        }
        return null;
    }

    private void updateFragment(Fragment fragment, Bundle bundle) {
        fragment.setArguments(bundle);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return screenTitles.get(position);
    }
}
