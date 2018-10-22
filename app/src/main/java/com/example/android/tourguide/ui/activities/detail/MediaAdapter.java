package com.example.android.tourguide.ui.activities.detail;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.tourguide.R;
import com.example.android.tourguide.databinding.ItemPhotosBinding;
import com.example.android.tourguide.utils.Utils;
import com.example.android.tourguide.viewholder.MediaViewHolder;
import com.library.android.common.appconstants.AppConstants;

public class MediaAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private TypedArray imageArray;

    public MediaAdapter(Context context) {
        this.context = context;
        imageArray = context.getResources().obtainTypedArray(R.array.sliding_images);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_photos, viewGroup, false);
        return new MediaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof MediaViewHolder) {
            MediaViewHolder holder = (MediaViewHolder) viewHolder;
            ItemPhotosBinding binding = holder.binding;
            if (binding != null && imageArray != null && imageArray.length() > 0) {
                Utils.loadImage(context, imageArray.getResourceId(i, AppConstants.NULL), R.drawable.ic_welcome_user, R.drawable.ic_user_default, binding.civ);
            }
        }
    }

    @Override
    public int getItemCount() {
        return imageArray != null ? imageArray.length() : 10;
    }
}
