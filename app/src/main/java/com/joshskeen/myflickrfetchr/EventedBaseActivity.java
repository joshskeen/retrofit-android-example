package com.joshskeen.myflickrfetchr;

import android.app.ProgressDialog;

import com.joshskeen.myflickrfetchr.event.HideDialogEvent;
import com.joshskeen.myflickrfetchr.event.ShowDialogEvent;

import de.greenrobot.event.EventBus;

/**
 * Created by joshskeen on 7/31/14.
 */
public abstract class EventedBaseActivity extends BaseActivity {

    private ProgressDialog mLoading;

    //register/unregister for events from the EventBus
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
