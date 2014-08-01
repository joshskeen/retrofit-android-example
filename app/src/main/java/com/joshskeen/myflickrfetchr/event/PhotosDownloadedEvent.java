package com.joshskeen.myflickrfetchr.event;

import com.joshskeen.myflickrfetchr.model.response.GetRecentPhotosResponse;

/**
 * Created by joshskeen on 7/31/14.
 */
public class PhotosDownloadedEvent {
    private GetRecentPhotosResponse mPhotosResponse;

    public PhotosDownloadedEvent(GetRecentPhotosResponse photosResponse) {
        mPhotosResponse = photosResponse;
    }

    public GetRecentPhotosResponse getPhotosResponse() {
        return mPhotosResponse;
    }

    public void setPhotosResponse(GetRecentPhotosResponse photosResponse) {
        mPhotosResponse = photosResponse;
    }
}
