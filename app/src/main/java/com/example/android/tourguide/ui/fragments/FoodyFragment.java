package com.example.android.tourguide.ui.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.example.android.tourguide.R;
import com.example.android.tourguide.adapter.HomeListAdapter;
import com.example.android.tourguide.databinding.LayoutRvBinding;
import com.example.android.tourguide.ui.baseui.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoodyFragment extends BaseFragment {

    public FoodyFragment() {
        // Required empty public constructor
    }


    @Override
    public int getLayoutId() {
        return R.layout.layout_rv;
    }

    @Override
    public void onViewStubInflated(View inflatedView, Bundle savedInstanceState) {
        LayoutRvBinding binding = LayoutRvBinding.bind(inflatedView);
        binding.rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.rv.setAdapter(new HomeListAdapter(getActivity()));
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
