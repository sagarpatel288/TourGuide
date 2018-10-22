package com.example.android.tourguide.ui.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.example.android.tourguide.R;
import com.example.android.tourguide.databinding.LayoutRvBinding;
import com.example.android.tourguide.ui.activities.detail.MediaAdapter;
import com.example.android.tourguide.ui.baseui.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class MediaFragment extends BaseFragment {

    public MediaFragment() {
        // Required empty public constructor
    }


    @Override
    public int getLayoutId() {
        return R.layout.layout_rv;
    }

    @Override
    public void onViewStubInflated(View inflatedView, Bundle savedInstanceState) {
        LayoutRvBinding binding = LayoutRvBinding.bind(inflatedView);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(4, OrientationHelper.VERTICAL);
        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);
        binding.rv.setLayoutManager(layoutManager);
        binding.rv.setAdapter(new MediaAdapter(getActivity()));
        binding.rv.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void initControllers() {

    }

    @Override
    public void handleViews() {

    }

    @Override
    public void setListeners() {

    }

    @Override
    public void restoreValues(Bundle savedInstanceState) {
    }

}
