package com.joshskeen.myflickrfetchr;

import android.app.Application;
import android.content.Context;

import com.joshskeen.myflickrfetchr.inject.MyFlickrFetchrModule;

import dagger.ObjectGraph;

public class MyFlickrFetchrApplication extends Application {

    private ObjectGraph mObjectGraph;

    @Override
    public void onCreate() {
        super.onCreate();
        mObjectGraph = ObjectGraph.create(new MyFlickrFetchrModule(this));
    }

    public static MyFlickrFetchrApplication get(Context context) {
        return (MyFlickrFetchrApplication) context.getApplicationContext();
    }

    public final void inject(Object object) {
        mObjectGraph.inject(object);
    }

}
