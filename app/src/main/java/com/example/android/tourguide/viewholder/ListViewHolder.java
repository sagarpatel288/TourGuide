package com.example.android.tourguide.viewholder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.android.tourguide.databinding.ItemListBinding;
import com.library.android.common.listeners.Callbacks;

public class ListViewHolder extends RecyclerView.ViewHolder {

    public ItemListBinding binding;
    private Callbacks.OnEventCallback onEventCallback;

    public ListViewHolder(@NonNull View itemView, ItemListBinding binding, final Callbacks.OnEventCallback onEventCallback) {
        super(itemView);
        this.binding = binding;
        this.onEventCallback = onEventCallback;
        Context context = itemView.getContext();
        if (context != null && binding != null) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onEventCallback != null) {
                        onEventCallback.onEventClick(v, (Integer) v.getTag());
                    }
                }
            });
        }
    }
}
