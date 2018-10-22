package com.library.android.common.utils;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.StyleSpan;

import com.library.android.common.R;

public class StringUtils {

    public static String makeCapital(String s) {
        if (isNotNullNotEmpty(s)) {
            return s.toUpperCase();
        } else {
            return "";
        }
    }

    public static boolean isNotNullNotEmpty(String s) {
        return s != null && !s.isEmpty();
    }

    public static String getDefaultString(String value, String defaultString) {
        if (isNotNullNotEmpty(value)) {
            return value;
        } else {
            return defaultString;
        }
    }

    /**
     * Gives formatted SpannableString
     *
     * @param partOne  First part of the SpannableString
     * @param partTwo  Second part of the spannableString
     * @param styleOne An int to set {@link android.graphics.Typeface} style for part one
     * @param styleTwo An int to set {@link android.graphics.Typeface} style for part two
     * @return {@link SpannableString}
     * @see <a href="https://developer.android.com/reference/android/text/SpannableString">SpannableString</a>
     * @since 1.0
     */
    public static SpannableString getFormattedString(String partOne, String partTwo, int styleOne, int styleTwo) {
        SpannableString spannableString = null;
        if (partOne != null && partTwo != null) {
            spannableString = new SpannableString(partOne + partTwo);
        } else if (partOne != null) {
            spannableString = new SpannableString(partOne);
        } else if (partTwo != null) {
            spannableString = new SpannableString(partTwo);
        }
        if (spannableString != null) {
            if (styleOne != 0 && partOne != null) {
                spannableString.setSpan(new StyleSpan(styleOne), 0, partOne.length(), 0);
            }
            if (styleTwo != 0 && partTwo != null) {
                spannableString.setSpan(new StyleSpan(styleTwo), partTwo.indexOf(partTwo), spannableString.length(), 0);
            }
        }
        return spannableString;
    }

    public static String getLongPlaceholder(Context context) {
        return context.getResources().getString(R.string.placeholder_long);
    }

    public static String getShortPlaceholder(Context context) {
        return context.getResources().getString(R.string.placeholder);
    }
}
