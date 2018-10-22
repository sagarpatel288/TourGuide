package com.example.android.tourguide.ui.activities.navdrawer;

import android.content.res.TypedArray;

import com.library.android.common.appconstants.AppConstants;

import ss.com.bannerslider.adapters.SliderAdapter;
import ss.com.bannerslider.viewholder.ImageSlideViewHolder;

public class MySliderAdapter extends SliderAdapter {

    private TypedArray imageArray;

    MySliderAdapter(TypedArray imageArray) {
        this.imageArray = imageArray;
    }

    @Override
    public int getItemCount() {
        return imageArray.length();
    }

    @Override
    public void onBindImageSlide(int position, ImageSlideViewHolder imageSlideViewHolder) {
        imageSlideViewHolder.bindImageSlide(imageArray.getResourceId(position, AppConstants.NULL));
    }
}
