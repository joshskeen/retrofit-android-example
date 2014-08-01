package com.joshskeen.myflickrfetchr;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.joshskeen.myflickrfetchr.event.PhotosDownloadedEvent;
import com.joshskeen.myflickrfetchr.model.PhotosManager;
import com.joshskeen.myflickrfetchr.model.response.Photo;
import com.joshskeen.myflickrfetchr.model.service.FlickrFetchrServiceManager;
import com.joshskeen.myflickrfetchr.model.service.PhotosDownloadedFailedEvent;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

public class MainActivity extends BaseActivity {

    @Inject
    FlickrFetchrServiceManager mServiceManager;

    @Inject
    PhotosManager mPhotosManager;

    private String TAG = "MainActivity";
    private ListView mPhotosListView;
    private Button mMakeRequestButton;

    @Override
    protected void onPause() {
        super.onPause();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMakeRequestButton = (Button) findViewById(R.id.mMakeRequestButton);
        mMakeRequestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //tell servicemanager to make the request
                mServiceManager.getRecentPhotos();
            }
        });

        mPhotosListView = (ListView) findViewById(R.id.mPhotosListView);
    }

    public void onEvent(PhotosDownloadedEvent event) {
        Log.d(TAG, "got photos:" + mPhotosManager.getPhotos());
        mPhotosListView.setAdapter(new ArrayAdapter<Photo>(this, android.R.layout.simple_list_item_1, mPhotosManager.getPhotos()));
    }

    public void onEvent(PhotosDownloadedFailedEvent event) {
        Log.d(TAG, "photo download failed!");
    }

}