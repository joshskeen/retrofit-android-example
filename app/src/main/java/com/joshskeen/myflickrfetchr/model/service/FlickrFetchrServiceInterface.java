package com.joshskeen.myflickrfetchr.model.service;

import com.joshskeen.myflickrfetchr.model.response.PhotosResponse;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by joshskeen on 7/31/14.
 */
public interface FlickrFetchrServiceInterface {

    @GET("/services/rest/?method=flickr.photos.getRecent")
    public PhotosResponse getRecentPhotos(@Query("per_page") int perPage, @Query("page") int page);

    @GET("/services/rest/?method=flickr.photos.getRecent")
    public void asyncGetRecentPhotos(@Query("per_page") int perPage, @Query("page") int page, Callback<PhotosResponse> callback);

}
