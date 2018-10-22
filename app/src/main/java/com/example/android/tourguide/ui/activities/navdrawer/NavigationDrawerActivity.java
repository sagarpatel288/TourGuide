package com.example.android.tourguide.ui.activities.navdrawer;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.android.tourguide.R;
import com.example.android.tourguide.adapter.ViewPagerAdapter;
import com.example.android.tourguide.appconstants.AppConstants;
import com.example.android.tourguide.databinding.ActivityNavigationDrawerBinding;
import com.example.android.tourguide.ui.baseui.BaseActivity;
import com.example.android.tourguide.ui.fragments.EventFragment;
import com.example.android.tourguide.ui.fragments.FoodyFragment;
import com.example.android.tourguide.ui.fragments.HealthyFragment;
import com.example.android.tourguide.ui.fragments.PlacesFragment;
import com.example.android.tourguide.ui.fragments.ShoppingFragment;
import com.example.android.tourguide.utils.Utils;
import com.library.android.common.utils.IntentKeys;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public class NavigationDrawerActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ActivityNavigationDrawerBinding binding;
    private ViewPagerAdapter viewPagerAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_navigation_drawer;
    }

    @Override
    public void onViewStubInflated(View inflatedView, Bundle savedInstanceState) {
        binding = ActivityNavigationDrawerBinding.bind(inflatedView);
    }

    @Override
    public void initControllers() {
        initViewPager();
    }

    private void initViewPager() {
        Bundle bundle = new Bundle();
        bundle.putString(IntentKeys.SOURCE_SCREEN, getClass().getSimpleName());
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), getHomeFragmentList(), Utils.getHomeTabTitles(this), bundle);
    }

    private List<Fragment> getHomeFragmentList() {
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new EventFragment());
        fragmentList.add(new FoodyFragment());
        fragmentList.add(new HealthyFragment());
        fragmentList.add(new PlacesFragment());
        fragmentList.add(new ShoppingFragment());
        return fragmentList;
    }

    @Override
    public void handleViews() {
        setSupportActionBar(binding.appbarDrawer.toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(getString(R.string.app_name));
        }
        binding.appbarDrawer.container.viewpager.setAdapter(viewPagerAdapter);
        // FIXME: 10/20/2018 sagar Why I had to set this? As not setting this makes viewstub null in baseFragment
        binding.appbarDrawer.container.viewpager.setOffscreenPageLimit(viewPagerAdapter.getCount());
        binding.appbarDrawer.container.viewpager.setPageMargin(0);
        binding.appbarDrawer.container.viewpager.setClipToPadding(false);
        binding.appbarDrawer.tabs.setupWithViewPager(binding.appbarDrawer.container.viewpager);
        setSlidingImages();
    }

    private void setSlidingImages() {
        SlidingImageAdapter slidingImageAdapter = new SlidingImageAdapter(this);
        binding.appbarDrawer.innerViewpager.setAdapter(slidingImageAdapter);
        binding.appbarDrawer.innerTabs.setupWithViewPager(binding.appbarDrawer.innerViewpager);
        setSlidingTimer();
    }

    private void setSlidingTimer() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(
                new SliderTask(this, binding.appbarDrawer.innerViewpager, getResources().obtainTypedArray(R.array.sliding_images)),
                AppConstants.SLIDING_DELAY,
                AppConstants.SLIDING_PERIOD);
    }

    @Override
    public void setListeners() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, binding.drawerLayout, binding.appbarDrawer.toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        binding.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        binding.navView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void restoreValues(Bundle savedInstanceState) {

    }

    @Override
    public void onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        binding.drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
