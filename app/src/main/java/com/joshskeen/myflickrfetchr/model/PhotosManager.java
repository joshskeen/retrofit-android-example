package com.joshskeen.myflickrfetchr.model;

import com.joshskeen.myflickrfetchr.model.response.Photo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joshskeen on 7/31/14.
 */
public class PhotosManager {

    List<Photo> mPhotos = new ArrayList<Photo>();

    public List<Photo> getPhotos() {
        return mPhotos;
    }

    public void setPhotos(List<Photo> photos) {
        mPhotos = photos;
    }
}
