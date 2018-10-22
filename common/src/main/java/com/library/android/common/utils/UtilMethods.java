package com.library.android.common.utils;

import android.text.Editable;

public class UtilMethods {

    /**
     * Verifies whether the given string value is null, empty or filled with value
     *
     * @param value A String that needs to be verified
     * @return true if the given value is neither null nor empty
     * @since 1.0
     */
    public static boolean checkNotNullEmpty(String value) {
        return value != null && !value.isEmpty();
    }

    /**
     * Verifies whether the given {@link Editable} value is null or not
     *
     * @param text An editable that needs to be verified
     * @return true if the given value is not null
     * @since 1.0
     */
    public static boolean checkNotNullEmpty(Editable text) {
        return text != null;
    }
}
