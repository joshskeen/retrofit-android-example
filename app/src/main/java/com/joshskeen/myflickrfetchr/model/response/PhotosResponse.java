package com.joshskeen.myflickrfetchr.model.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by joshskeen on 7/31/14.
 */
public class PhotosResponse {

    @SerializedName("photos")
    public PhotoResponse mPhotoResponse;

    @Override
    public String toString() {
        return "PhotosResponse{" +
                "mPhotoResponse=" + mPhotoResponse +
                '}';
    }
}
