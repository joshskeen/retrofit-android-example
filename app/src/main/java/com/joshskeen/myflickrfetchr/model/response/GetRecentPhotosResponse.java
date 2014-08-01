package com.joshskeen.myflickrfetchr.model.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by joshskeen on 7/31/14.
 */
public class GetRecentPhotosResponse {

    @SerializedName("photos")
    public Photos mPhotos;

    @SerializedName("stat")
    public String mStatus;

    @Override
    public String toString() {
        return "GetRecentPhotosResponse{" +
                "mPhotos=" + mPhotos +
                ", mStatus='" + mStatus + '\'' +
                '}';
    }
}
