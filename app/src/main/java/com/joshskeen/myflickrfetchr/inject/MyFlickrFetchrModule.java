package com.joshskeen.myflickrfetchr.inject;

import com.joshskeen.myflickrfetchr.MainActivity;
import com.joshskeen.myflickrfetchr.MyFlickrFetchrApplication;
import com.joshskeen.myflickrfetchr.model.PhotosManager;
import com.joshskeen.myflickrfetchr.model.service.FlickrFetchrService;
import com.joshskeen.myflickrfetchr.model.service.FlickrFetchrServiceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by joshskeen on 7/31/14.
 */
@Module(injects = {
        MainActivity.class,
}, complete = true)
public class MyFlickrFetchrModule {

    private MyFlickrFetchrApplication mMyFlickrFetchrApplication;

    public MyFlickrFetchrModule(MyFlickrFetchrApplication myFlickrFetchrApplication) {
        mMyFlickrFetchrApplication = myFlickrFetchrApplication;
    }

    @Provides
    public FlickrFetchrService provideFlickrFetchrService() {
        return new FlickrFetchrService();
    }

    @Provides
    public FlickrFetchrServiceManager provideFlickrFetchrServiceManager(FlickrFetchrService service, PhotosManager photosManager) {
        return new FlickrFetchrServiceManager(service, photosManager);
    }

    @Provides
    @Singleton
    public PhotosManager providePhotoManager() {
        return new PhotosManager();
    }

}
