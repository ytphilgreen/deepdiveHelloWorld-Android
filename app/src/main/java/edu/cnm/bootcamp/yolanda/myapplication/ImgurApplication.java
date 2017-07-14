package edu.cnm.bootcamp.yolanda.myapplication;

import android.app.Application;

import edu.cnm.bootcamp.yolanda.myapplication.api.API;

/**
 * Created by ali on 7/14/2017.
 */

public class ImgurApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        API.init();

    }
}
