package com.example.android.tourguide.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.tourguide.R;
import com.example.android.tourguide.databinding.ItemListBinding;
import com.example.android.tourguide.model.TourGuide;
import com.example.android.tourguide.ui.activities.detail.ItemDetailActivity;
import com.example.android.tourguide.utils.Utils;
import com.example.android.tourguide.viewholder.ListViewHolder;
import com.library.android.common.listeners.Callbacks;
import com.library.android.common.utils.IntentKeys;
import com.library.android.common.utils.ViewUtils;

import java.util.List;

public class HomeListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements Callbacks.OnEventCallback {

    private Context context;
    private List<TourGuide> tourGuideList;

    public HomeListAdapter(Context context) {
        this.context = context;
        tourGuideList = TourGuide.getTourGuideList(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list, viewGroup, false);
        ItemListBinding binding = ItemListBinding.bind(view);
        return new ListViewHolder(view, binding, this);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof ListViewHolder) {
            ListViewHolder holder = (ListViewHolder) viewHolder;
            ItemListBinding binding = holder.binding;
            TourGuide tourGuide = tourGuideList.get(i);
            if (context != null && binding != null) {
                setTags(holder, binding, i);
                setData(binding, tourGuide, i);
            }
        }
    }

    private void setTags(ListViewHolder holder, ItemListBinding binding, int i) {
        holder.itemView.setTag(i);
    }

    private void setData(ItemListBinding binding, TourGuide tourGuide, int position) {
        ViewUtils.setText(binding.cbtnTitle, tourGuide.getTitle());
        ViewUtils.setText(binding.cbtnSubtitle, tourGuide.getSubTitle());
        ViewUtils.setText(binding.cbtnAddress, tourGuide.getAddress());
        ViewUtils.setText(binding.cbtnCategory, tourGuide.getCategory());
        ViewUtils.setText(binding.cbtnDistance, tourGuide.getDistance());
        ViewUtils.setText(binding.cbtnReviews, String.format("(%s)", tourGuide.getReviews()));
        binding.ratingbar.setRating(tourGuide.getRating());
        ViewUtils.setScrollable(binding.cbtnAddress, binding.cbtnCategory, binding.cbtnDistance, binding.cbtnReviews);
        Utils.loadImage(context, tourGuide.getImageResId(), R.drawable.ic_welcome_user, R.drawable.ic_user_default, binding.civProfile);
    }

    @Override
    public int getItemCount() {
        return tourGuideList.size();
    }

    @Override
    public void onEventClick(View view, int positionTag) {
        TourGuide tourGuide = tourGuideList.get(positionTag);
        Intent intent = new Intent(context, ItemDetailActivity.class);
        intent.putExtra(IntentKeys.PARCEL, tourGuide);
        context.startActivity(intent);
    }
}
