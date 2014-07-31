package com.joshskeen.myflickrfetchr.event;

import com.joshskeen.myflickrfetchr.model.response.PhotosResponse;

/**
 * Created by joshskeen on 7/31/14.
 */
public class PhotosDownloadedEvent {
    private PhotosResponse mPhotosResponse;

    public PhotosDownloadedEvent(PhotosResponse photosResponse) {
        mPhotosResponse = photosResponse;
    }

    public PhotosResponse getPhotosResponse() {
        return mPhotosResponse;
    }

    public void setPhotosResponse(PhotosResponse photosResponse) {
        mPhotosResponse = photosResponse;
    }
}
