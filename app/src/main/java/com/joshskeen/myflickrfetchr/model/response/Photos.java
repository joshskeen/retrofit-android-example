package com.joshskeen.myflickrfetchr.model.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by joshskeen on 7/31/14.
 */
public class Photos {

    @SerializedName("photo")
    public List<Photo> mPhotos;
    @SerializedName("page")
    public int mPage;
    @SerializedName("pages")
    public int mPages;
    @SerializedName("perpage")
    public int mPerPage;
    @SerializedName("total")
    public int mTotal;

    @Override
    public String toString() {
        return "Photos{" +
                "mPhotos=" + mPhotos +
                ", mPage=" + mPage +
                ", mPages=" + mPages +
                ", mPerPage=" + mPerPage +
                ", mTotal=" + mTotal +
                '}';
    }
}
