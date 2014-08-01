package com.joshskeen.myflickrfetchr;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

/**
 * Created by joshskeen on 7/31/14.
 */
public abstract class BaseActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyFlickrFetchrApplication.get(this).inject(this);
    }


}
