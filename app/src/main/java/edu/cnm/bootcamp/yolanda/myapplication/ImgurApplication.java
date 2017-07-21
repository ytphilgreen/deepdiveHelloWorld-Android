package edu.cnm.bootcamp.yolanda.myapplication;

import android.app.Application;

import java.util.List;

import edu.cnm.bootcamp.yolanda.myapplication.api.API;
import edu.cnm.bootcamp.yolanda.myapplication.objects.GalleryResponse;
import edu.cnm.bootcamp.yolanda.myapplication.objects.Image;
import rx.SingleSubscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

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
