package com.joshskeen.myflickrfetchr.model.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by joshskeen on 7/31/14.
 */
public class PhotoResponse {

    @SerializedName("photo")
    public List<Photo> mPhotos;

    @Override
    public String toString() {
        return "PhotoResponse{" +
                "mPhotos=" + mPhotos +
                '}';
    }
}
