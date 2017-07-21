package edu.cnm.bootcamp.yolanda.myapplication.objects;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Single;

/**
 * Created by ali on 7/20/2017.
 */

public class GalleryResponse {
   @SerializedName("success")
    boolean success;

    @SerializedName("status")
    int status;

    @SerializedName("data")
    List<Image> data;

    public boolean getSuccess() {
        return success;
    }

    public int getStatus() {
        return status;
    }

    public List<Image> getData() {
        return data;
    }
}
