package com.library.android.common.listeners;


import android.view.View;

import com.library.android.common.ui.dialogs.MyAlertDialog;

public abstract class Callbacks {
    /**
     * Interface callback from {@link MyAlertDialog} to host
     * <p>
     * Gives callback to host for whether {@link MyAlertDialog#btnLeft} or {@link MyAlertDialog#btnRight} has clicked
     * <p>
     *
     * @since 1.0
     */
    public interface OnDialogBtnClick {
        void onLeftBtnClick();

        void onRightBtnClick();
    }

    public interface OnFragmentLoad {
        void onFragmentVisible();

        void onFragmentHide();
    }

    public interface OnEventCallback {
        void onEventClick(View view, int positionTag);
    }
}
