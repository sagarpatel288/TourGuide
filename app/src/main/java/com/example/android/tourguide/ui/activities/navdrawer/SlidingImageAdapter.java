package com.example.android.tourguide.ui.activities.navdrawer;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.tourguide.R;
import com.example.android.tourguide.databinding.ItemSlidingImagesBinding;
import com.example.android.tourguide.ui.baseui.GlideApp;
import com.library.android.common.appconstants.AppConstants;

public class SlidingImageAdapter extends PagerAdapter {

    private Context context;
    private TypedArray imageArray;

    public SlidingImageAdapter(Context context) {
        this.context = context;
        imageArray = context.getResources().obtainTypedArray(R.array.sliding_images);
    }

    @Override
    public int getCount() {
        return imageArray.length();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.item_sliding_images, null);
        ItemSlidingImagesBinding binding = ItemSlidingImagesBinding.bind(view);
//        binding.imageView.setImageResource(imageArray.getResourceId(position, AppConstants.NULL));
        GlideApp.with(context)
                .load(imageArray.getResourceId(position, AppConstants.NULL))
                .into(binding.imageView);
        ViewPager viewPager = (ViewPager) container;
        viewPager.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ViewPager viewPager = (ViewPager) container;
        View view = (View) object;
        viewPager.removeView(view);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return super.getItemPosition(object);
    }
}
