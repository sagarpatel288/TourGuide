package com.example.android.tourguide.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.android.tourguide.databinding.ItemPhotosBinding;

public class MediaViewHolder extends RecyclerView.ViewHolder {

    public ItemPhotosBinding binding;

    public MediaViewHolder(@NonNull View itemView) {
        super(itemView);
        binding = ItemPhotosBinding.bind(itemView);
    }
}
