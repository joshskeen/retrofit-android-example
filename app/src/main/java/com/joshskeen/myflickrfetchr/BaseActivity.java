package com.joshskeen.myflickrfetchr;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.joshskeen.myflickrfetchr.event.HideDialogEvent;
import com.joshskeen.myflickrfetchr.event.ShowDialogEvent;

/**
 * Created by joshskeen on 7/31/14.
 */
public abstract class BaseActivity extends FragmentActivity {

    private ProgressDialog mLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyFlickrFetchrApplication.get(this).inject(this);
    }

    public void onEvent(ShowDialogEvent event) {
        mLoading = ProgressDialog.show(this, "Loading", "loading...", true);
    }

    public void onEvent(HideDialogEvent event) {
        if (mLoading == null) {
            return;
        }
        mLoading.dismiss();
        mLoading = null;
    }

}
