package com.joshskeen.myflickrfetchr.model.service;

import com.joshskeen.myflickrfetchr.model.response.GetRecentPhotosResponse;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by joshskeen on 7/31/14.
 */
public interface FlickrFetchrServiceInterface {

    @GET("/services/rest/?method=flickr.photos.getRecent")
    public GetRecentPhotosResponse getRecentPhotos(@Query("per_page") int perPage, @Query("page") int page);

    //uses the asynchronous callback interface Retrofit provides out of the box
    @GET("/services/rest/?method=flickr.photos.getRecent")
    public void asyncGetRecentPhotos(@Query("per_page") int perPage, @Query("page") int page, Callback<GetRecentPhotosResponse> callback);

}
