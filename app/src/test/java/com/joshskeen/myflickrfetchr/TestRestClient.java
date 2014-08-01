package com.joshskeen.myflickrfetchr;


import com.joshskeen.myflickrfetchr.model.response.GetRecentPhotosResponse;
import com.joshskeen.myflickrfetchr.model.service.FlickrFetchrService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.fest.assertions.api.Assertions.assertThat;

@Config(emulateSdk = 18)
@RunWith(RobolectricTestRunner.class)
public class TestRestClient {

    private FlickrFetchrService mFlickrFetchrService;

    @Before
    public void setup() {
        mFlickrFetchrService = new FlickrFetchrService();
    }

    @Test
    public void testGetRecentPhotosRequest() {
        GetRecentPhotosResponse recentPhotos = mFlickrFetchrService.getRecentPhotos(10, 1);
        assertThat(recentPhotos.mPhotosInfo.mPhotos).hasSize(10);
    }

}