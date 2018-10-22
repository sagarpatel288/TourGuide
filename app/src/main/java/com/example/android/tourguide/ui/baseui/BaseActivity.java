package com.example.android.tourguide.ui.baseui;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewStub;
import android.widget.ProgressBar;

import com.library.android.common.R;
import com.library.android.common.databinding.BaseViewStubLayoutBinding;

import butterknife.BindView;
import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

    BaseViewStubLayoutBinding binding;
    @BindView(R.id.progressbar)
    ProgressBar progressbar;
    @BindView(R.id.view_stub)
    ViewStub viewStub;

    private boolean hasStubInflated;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Normal method to inflate the layout
        setContentView(R.layout.base_view_stub_layout);
        ButterKnife.bind(this);
        //Data binding to inflate the layout and binding views at the same time
//        binding = BaseViewStubLayoutBinding.inflate(getLayoutInflater());
        /*For fragments, listview or recyclerview adapter, we can use below method:
        binding = DataBindingUtil.setContentView(this, R.layout.base_activity_layout);*/
        viewStub.setLayoutResource(getLayoutId());
        viewStub.setOnInflateListener(new ViewStub.OnInflateListener() {
            @Override
            public void onInflate(ViewStub stub, View inflated) {
                //Abstract method
                onViewStubInflated(inflated, savedInstanceState);
                ButterKnife.bind(this, inflated);
                initControllers();
                handleViews();
                setListeners();
                restoreValues(savedInstanceState);
                //Normal method to hide progress bar
                onViewStubInflated();
            }
        });

        if (!hasStubInflated) {
            viewStub.inflate();
        }
    }

    public abstract int getLayoutId();

    //Bind the inflatedView for data binding
    public abstract void onViewStubInflated(View inflatedView, Bundle savedInstanceState);

    public abstract void initControllers();

    public abstract void handleViews();

    public abstract void setListeners();

    public abstract void restoreValues(Bundle savedInstanceState);

    private void onViewStubInflated() {
        hasStubInflated = true;
        hideProgressbar();
    }

    public void hideProgressbar() {
        if (progressbar != null) {
            progressbar.setVisibility(View.GONE);
        }
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        hasStubInflated = false;
    }

    public ViewModel getViewModel(Class viewModelClass) {
        return ViewModelProviders.of(this).get(viewModelClass);
    }
}
