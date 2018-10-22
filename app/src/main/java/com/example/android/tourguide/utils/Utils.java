package com.example.android.tourguide.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.widget.ImageView;

import com.example.android.tourguide.R;
import com.example.android.tourguide.ui.baseui.GlideApp;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static List<String> getHomeTabTitles(Context context) {
        List<String> screenTitles = new ArrayList<>();
        screenTitles.add(context.getString(R.string.label_events));
        screenTitles.add(context.getString(R.string.label_food));
        screenTitles.add(context.getString(R.string.label_health));
        screenTitles.add(context.getString(R.string.label_places));
        screenTitles.add(context.getString(R.string.label_shopping));
        return screenTitles;
    }

    public static List<String> getItemDetailTabTitles(Context context) {
        List<String> screenTitles = new ArrayList<>();
        screenTitles.add(context.getString(R.string.label_about));
        screenTitles.add(context.getString(R.string.label_reviews_title));
        screenTitles.add(context.getString(R.string.label_media));
        return screenTitles;
    }

    public static List<Integer> getImageResIdList(Context context) {
        List<Integer> imageResIdList = new ArrayList<>();
        TypedArray imageArray = context.getResources().obtainTypedArray(R.array.sliding_images);
        if (imageArray.length() > 0) {
            for (int i = 0; i < imageArray.length(); i++) {
                imageResIdList.add(imageArray.getResourceId(i, com.library.android.common.appconstants.AppConstants.NULL));
            }
        }
        imageArray.recycle();
        return imageResIdList;
    }

    public static void loadImage(Context context, int imageResId, int placeHolderResId, int errorImageResId, ImageView imageView) {
        GlideApp.with(context)
                .load(imageResId)
                .placeholder(placeHolderResId)
                .error(errorImageResId)
                .into(imageView);
    }
}
