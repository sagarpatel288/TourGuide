package com.example.android.tourguide.ui.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.example.android.tourguide.R;
import com.example.android.tourguide.databinding.FragmentAboutBinding;
import com.example.android.tourguide.model.TourGuide;
import com.example.android.tourguide.ui.baseui.BaseFragment;
import com.library.android.common.utils.IntentKeys;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutFragment extends BaseFragment {

    private FragmentAboutBinding binding;

    public AboutFragment() {
        // Required empty public constructor
    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_about;
    }

    @Override
    public void onViewStubInflated(View inflatedView, Bundle savedInstanceState) {
        binding = FragmentAboutBinding.bind(inflatedView);
    }

    @Override
    public void initControllers() {

    }

    @Override
    public void handleViews() {
        if (getArguments() != null) {
            TourGuide tourGuide = getArguments().getParcelable(IntentKeys.PARCEL);
            if (tourGuide != null) {
                setData(tourGuide);
            }
        }
    }

    private void setData(TourGuide tourGuide) {
        binding.tvName.setText(tourGuide.getTitle());
        binding.tvAddress.setText(tourGuide.getAddress());
        binding.cbtnDescription.setText(tourGuide.getDescription());
    }

    @Override
    public void setListeners() {

    }

    @Override
    public void restoreValues(Bundle savedInstanceState) {
    }

}
