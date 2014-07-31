package com.joshskeen.myflickrfetchr.model.service;

import com.squareup.okhttp.OkHttpClient;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.android.AndroidLog;
import retrofit.client.OkClient;

public abstract class FlickrFetchrServiceBase {

    public static final String HEADER_ACCEPT = "Accept";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String APPLICATION_JSON = "application/json";
    public static final String SERVER_URL = "https://api.flickr.com";
    public static final String API_KEY = "52b082213eb8821fb5a02307573b4c7d";
    //status codes that indicate there will be no response body to parse to error messages
    private static final String TAG = "FlickrFetchrService";


    protected FlickrFetchrServiceInterface getFlickrFetchrServiceInterface() {
        return getRestAdapter().create(FlickrFetchrServiceInterface.class);
    }

    public RestAdapter getRestAdapter() {
        OkHttpClient client = new OkHttpClient();
        OkClient retrofitClient = new OkClient(client);
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(SERVER_URL)
                .setRequestInterceptor(new RequestInterceptor() {
                    @Override
                    public void intercept(RequestFacade request) {
                        request.addQueryParam("api_key", API_KEY);
                        request.addQueryParam("format", "json");
                        request.addQueryParam("nojsoncallback", "1"); //disable the JSONP callback stuff flickr seems to assume we want
                    }
                })
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setLog(new AndroidLog(TAG))
                .setClient(retrofitClient)
                .build();
        return restAdapter;
    }

}
