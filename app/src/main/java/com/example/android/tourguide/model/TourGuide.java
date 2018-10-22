package com.example.android.tourguide.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

import com.example.android.tourguide.utils.Utils;
import com.library.android.common.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TourGuide implements Parcelable {
    public static final Creator<TourGuide> CREATOR = new Creator<TourGuide>() {
        @Override
        public TourGuide createFromParcel(Parcel source) {
            return new TourGuide(source);
        }

        @Override
        public TourGuide[] newArray(int size) {
            return new TourGuide[size];
        }
    };
    private int imageResId;
    private String title;
    private String subTitle;
    private String description;
    private String address;
    private String distance;
    private String category;
    private String reviews;
    private float rating;
    private List<Integer> imageResIdList;

    public TourGuide(int imageResId, String title, String subTitle, String description, String address, String distance, String category, String reviews, float rating, List<Integer> imageResIdList) {
        this.imageResId = imageResId;
        this.title = title;
        this.subTitle = subTitle;
        this.description = description;
        this.address = address;
        this.distance = distance;
        this.category = category;
        this.reviews = reviews;
        this.rating = rating;
        this.imageResIdList = imageResIdList;
    }

    protected TourGuide(Parcel in) {
        this.imageResId = in.readInt();
        this.title = in.readString();
        this.subTitle = in.readString();
        this.description = in.readString();
        this.address = in.readString();
        this.distance = in.readString();
        this.category = in.readString();
        this.reviews = in.readString();
        this.rating = in.readFloat();
        this.imageResIdList = new ArrayList<Integer>();
        in.readList(this.imageResIdList, Integer.class.getClassLoader());
    }

    public List<Integer> getImageResIdList() {
        return imageResIdList;
    }

    public void setImageResIdList(List<Integer> imageResIdList) {
        this.imageResIdList = imageResIdList;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getcategory() {
        return category;
    }

    public void setcategory(String category) {
        this.category = category;
    }

    public String getReviews() {
        return reviews;
    }

    public void setReviews(String reviews) {
        this.reviews = reviews;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public static List<TourGuide> getTourGuideList(Context context) {
        List<TourGuide> tourGuideList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Random r = new Random();
            List<Integer> imageResIds = Utils.getImageResIdList(context);
            int highest = imageResIds.size(); //Exclusive
            int lowest = 0;
            int random = r.nextInt(highest - lowest) + lowest; //Low Inclusive - High Exclusive
            tourGuideList.add(new TourGuide(
                    i < highest ? imageResIds.get(i) : imageResIds.get(random),
                    String.format("%s - %s", "list item title ", String.valueOf(i)),
                    String.format("%s - %s", "list item subtitle ", String.valueOf(i)),
                    String.format("%s - %s\n%s", "list item description ", String.valueOf(i), StringUtils.getLongPlaceholder(context)),
                    String.format("%s - %s", "list item address ", String.valueOf(i)),
                    String.format("%s - %s", "list item distance ", String.valueOf(i)),
                    String.format("%s - %s", "list item category ", String.valueOf(i)),
                    String.format("%s - %s", "list item reviews ", String.valueOf(i)),
                    i > 5 ? 5 : i,
                    imageResIds
            ));
        }
        return tourGuideList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.imageResId);
        dest.writeString(this.title);
        dest.writeString(this.subTitle);
        dest.writeString(this.description);
        dest.writeString(this.address);
        dest.writeString(this.distance);
        dest.writeString(this.category);
        dest.writeString(this.reviews);
        dest.writeFloat(this.rating);
        dest.writeList(this.imageResIdList);
    }
}
