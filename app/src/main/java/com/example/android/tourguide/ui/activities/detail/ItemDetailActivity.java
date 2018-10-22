package com.example.android.tourguide.ui.activities.detail;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.example.android.tourguide.R;
import com.example.android.tourguide.adapter.ViewPagerAdapter;
import com.example.android.tourguide.appconstants.AppConstants;
import com.example.android.tourguide.databinding.ActivityDetailBinding;
import com.example.android.tourguide.ui.activities.navdrawer.SliderTask;
import com.example.android.tourguide.ui.activities.navdrawer.SlidingImageAdapter;
import com.example.android.tourguide.ui.baseui.BaseActivity;
import com.example.android.tourguide.ui.fragments.AboutFragment;
import com.example.android.tourguide.ui.fragments.MediaFragment;
import com.example.android.tourguide.ui.fragments.ReviewsFragment;
import com.example.android.tourguide.utils.Utils;
import com.library.android.common.utils.IntentKeys;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public class ItemDetailActivity extends BaseActivity {

    private ActivityDetailBinding binding;
    private ViewPagerAdapter viewPagerAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_detail;
    }

    @Override
    public void onViewStubInflated(View inflatedView, Bundle savedInstanceState) {
        binding = ActivityDetailBinding.bind(inflatedView);
    }

    @Override
    public void initControllers() {
        Bundle bundle = new Bundle();
        bundle.putString(IntentKeys.SOURCE_SCREEN, getClass().getSimpleName());
        if (getIntent() != null) {
            if (getIntent().hasExtra(IntentKeys.PARCEL)) {
                bundle.putParcelable(IntentKeys.PARCEL, getIntent().getParcelableExtra(IntentKeys.PARCEL));
            }
        }
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), getItemDetailFragments(), Utils.getItemDetailTabTitles(this), bundle);
    }

    private List<Fragment> getItemDetailFragments() {
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new AboutFragment());
        fragmentList.add(new ReviewsFragment());
        fragmentList.add(new MediaFragment());
        return fragmentList;
    }

    @Override
    public void handleViews() {
        setSupportActionBar(binding.toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setTitle(getString(R.string.label_detail));
        }
        binding.container.viewpager.setAdapter(viewPagerAdapter);
        // FIXME: 10/20/2018 sagar Why I had to set this? As not setting this makes viewstub null in baseFragment
        binding.container.viewpager.setOffscreenPageLimit(viewPagerAdapter.getCount());
        binding.container.viewpager.setPageMargin(0);
        binding.container.viewpager.setClipToPadding(false);
        binding.tabs.setupWithViewPager(binding.container.viewpager);
        setSlidingImages();
    }


    private void setSlidingImages() {
        SlidingImageAdapter slidingImageAdapter = new SlidingImageAdapter(this);
        binding.innerViewpager.setAdapter(slidingImageAdapter);
        binding.innerTabs.setupWithViewPager(binding.innerViewpager);
        setSlidingTimer();
    }

    private void setSlidingTimer() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(
                new SliderTask(this, binding.innerViewpager, getResources().obtainTypedArray(R.array.sliding_images)),
                AppConstants.SLIDING_DELAY,
                AppConstants.SLIDING_PERIOD);
    }

    @Override
    public void setListeners() {

    }

    @Override
    public void restoreValues(Bundle savedInstanceState) {

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
