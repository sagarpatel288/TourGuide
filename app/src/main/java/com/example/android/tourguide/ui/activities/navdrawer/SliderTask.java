package com.example.android.tourguide.ui.activities.navdrawer;

import android.app.Activity;
import android.content.res.TypedArray;
import android.support.v4.view.ViewPager;

import java.util.TimerTask;

public class SliderTask extends TimerTask {

    private Activity activity;
    private ViewPager viewPager;
    private TypedArray imageArray;

    public SliderTask(Activity activity, ViewPager viewPager, TypedArray imageArray) {
        this.activity = activity;
        this.viewPager = viewPager;
        this.imageArray = imageArray;
    }

    @Override
    public void run() {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (viewPager.getCurrentItem() < imageArray.length() - 1) {
                    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                } else {
                    viewPager.setCurrentItem(0);
                }
            }
        });
    }
}
