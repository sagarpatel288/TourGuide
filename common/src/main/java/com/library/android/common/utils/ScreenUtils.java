package com.library.android.common.utils;

import android.app.Activity;
import android.util.DisplayMetrics;

public class ScreenUtils {

    /**
     * Gives an int array which will have width and height of screen respectively
     *
     * @since 1.0
     */
    public static int[] getScreenWidthHeight(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;
        return new int[]{width, height};
    }
}
