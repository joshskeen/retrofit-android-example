package com.joshskeen.myflickrfetchr.model.service;

import android.util.Log;

import com.joshskeen.myflickrfetchr.event.HideDialogEvent;
import com.joshskeen.myflickrfetchr.event.PhotosDownloadedEvent;
import com.joshskeen.myflickrfetchr.event.ShowDialogEvent;
import com.joshskeen.myflickrfetchr.model.PhotosManager;
import com.joshskeen.myflickrfetchr.model.response.GetRecentPhotosResponse;
import com.joshskeen.myflickrfetchr.model.response.Photo;

import java.util.List;

import de.greenrobot.event.EventBus;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by joshskeen on 7/31/14.
 */
public class FlickrFetchrServiceManager {

    private static final String TAG = "FlickrFetchrServiceManager";
    private FlickrFetchrService mService;
    private PhotosManager mPhotosManager;


    public FlickrFetchrServiceManager(FlickrFetchrService service, PhotosManager photosManager) {
        mService = service;
        mPhotosManager = photosManager;
    }

    public void getRecentPhotos() {
        EventBus.getDefault().post(new ShowDialogEvent());
        //this uses the async callback interface Retrofit provides! (if last argument is a Callback, the request is async)
        mService.asyncGetRecentPhotos(10, 1, new Callback<GetRecentPhotosResponse>() {
            @Override
            public void success(GetRecentPhotosResponse photosResponse, Response response) {
                EventBus.getDefault().post(new HideDialogEvent());
                //update singleton model object
                List<Photo> photos = photosResponse.mPhotos.mPhotos;
                mPhotosManager.setPhotos(photos);
                //notify the ui thread
                EventBus.getDefault().post(new PhotosDownloadedEvent(photosResponse));
            }

            @Override
            public void failure(RetrofitError error) {
                EventBus.getDefault().post(new HideDialogEvent());
                Log.e(TAG, "something Bad happened!");
                EventBus.getDefault().post(new PhotosDownloadedFailedEvent(error));
            }
        });
    }

}
