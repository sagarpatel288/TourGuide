package com.library.android.common.customviews;

import android.content.Context;
import android.os.Build;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.util.TypedValue;

public class CustomImageView extends AppCompatImageView {


    public CustomImageView(Context context) {
        super(context);
        setRipple();
    }

    private void setRipple() {
        TypedValue outValue = new TypedValue();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getContext().getTheme().resolveAttribute(android.R.attr.selectableItemBackgroundBorderless, outValue, true);
        } else {
            getContext().getTheme().resolveAttribute(android.R.attr.selectableItemBackground, outValue, true);
        }
        setBackgroundResource(outValue.resourceId);
    }

    public CustomImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setRipple();
    }

    public CustomImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setRipple();
    }
}
