package com.joshskeen.myflickrfetchr.model.service;

import retrofit.RetrofitError;

/**
 * Created by joshskeen on 7/31/14.
 */
public class PhotosDownloadedFailedEvent {
    private RetrofitError mError;

    public PhotosDownloadedFailedEvent(RetrofitError error) {
        mError = error;
    }

    public RetrofitError getError() {
        return mError;
    }
}
