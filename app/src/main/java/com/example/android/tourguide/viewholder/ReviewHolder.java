package com.example.android.tourguide.viewholder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.android.tourguide.R;
import com.example.android.tourguide.databinding.ItemReviewsBinding;
import com.library.android.common.utils.ViewUtils;

public class ReviewHolder extends RecyclerView.ViewHolder {

    public ReviewHolder(@NonNull View itemView) {
        super(itemView);
        ItemReviewsBinding binding = ItemReviewsBinding.bind(itemView);
        Context context = itemView.getContext();
        if (context != null && binding != null) {
            ViewUtils.setText(binding.cbtnTitle, context.getResources().getString(R.string.label_name));
            ViewUtils.setText(binding.cbtnDescription, context.getResources().getString(R.string.placeholder_long));
        }
    }
}
