package com.joshskeen.myflickrfetchr.model.service;

import com.joshskeen.myflickrfetchr.model.response.GetRecentPhotosResponse;

import retrofit.Callback;
import retrofit.http.Query;

public class FlickrFetchrService extends FlickrFetchrServiceBase {

    public GetRecentPhotosResponse getRecentPhotos(@Query("per_page") int perPage, @Query("page") int page) {
        return getFlickrFetchrServiceInterface().getRecentPhotos(perPage, page);
    }

    public void asyncGetRecentPhotos(@Query("per_page") int perPage, @Query("page") int page, Callback<GetRecentPhotosResponse> callback) {
        getFlickrFetchrServiceInterface().asyncGetRecentPhotos(perPage, page, callback);
    }

}
