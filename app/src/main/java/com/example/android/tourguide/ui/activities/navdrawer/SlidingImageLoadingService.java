package com.example.android.tourguide.ui.activities.navdrawer;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.android.tourguide.ui.baseui.GlideApp;

import ss.com.bannerslider.ImageLoadingService;

public class SlidingImageLoadingService implements ImageLoadingService {

    private Context context;

    public SlidingImageLoadingService(Context context) {
        this.context = context;
    }

    @Override
    public void loadImage(String url, ImageView imageView) {
        Glide.with(context).load(url).into(imageView);
    }

    @Override
    public void loadImage(int resource, ImageView imageView) {
        Glide.with(context).load(resource).into(imageView);
    }

    @Override
    public void loadImage(String url, int placeHolder, int errorDrawable, ImageView imageView) {
        GlideApp.with(context)
                .load(url)
                .placeholder(placeHolder)
                .error(errorDrawable)
                .centerCrop()
                .into(imageView);
    }
}
