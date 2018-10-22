package com.library.android.common.utils;

import android.content.Context;
import android.graphics.PorterDuff;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ViewUtils {

    /*Shows toast message*/
    public static void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    /*Toggles visibility for given view/s*/
    public static void toggleVisibility(int visibility, View... views) {
        if (views != null && views.length > 0) {
            for (View view : views) {
                view.setVisibility(visibility);
            }
        }
    }

    /*Tints color*/
    public static void tintColor(ImageView imageView, int color) {
        imageView.setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
    }

    public static void setSelected(View... views) {
        if (views != null && views.length > 0) {
            for (View view : views) {
                view.setSelected(true);
            }
        }
    }

    public static void setText(TextView tv, String text) {
        if (tv != null) {
            tv.setText(StringUtils.getDefaultString(text, ""));
        }
    }

    public static void setScrollable(TextView... textViews) {
        if (textViews != null) {
            for (TextView tv : textViews) {
                tv.setMovementMethod(new ScrollingMovementMethod());
                tv.setSelected(true);
            }
        }
    }
}
