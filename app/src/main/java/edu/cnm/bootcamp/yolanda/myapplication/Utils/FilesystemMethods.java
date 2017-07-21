package edu.cnm.bootcamp.yolanda.myapplication.Utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by ali on 7/21/2017.
 */

public class FilesystemMethods {
    public static boolean downloadFile(Context context, String url){
        boolean success = false;
        if (url != null && url.indexOf("/")> 0) {
            String filename = url.substring(url.lastIndexOf("/") + 1);
          try {
              URL u = new URL(url);
              HttpURLConnection uc = (HttpURLConnection) u.openConnection();
              uc.setRequestProperty("Accept", "image/*");

              InputStream in = uc.getInputStream();
              if (in != null) {
                  int length = uc.getContentLength();
                  String dlpath = context.getCacheDir().getAbsolutePath();
                  File f = new File(dlpath, filename);
                  FileOutputStream outfile = new FileOutputStream(f);

                  byte[] buffer = new byte[1024];
                  int len;

                  while ((len = in.read(buffer)) != -1) {
                      outfile.write(buffer, 0, -1);
                  }
              }
          } catch (Exception e){
              e.printStackTrace();
          }
        }
        return success;
    }
    public static Bitmap getDownloadedImage(Context context, String url) {
        Bitmap bitmap = null;

        if (url != null && url.indexOf("/") > 0) {
            String filename = url.substring(url.lastIndexOf("/") + 1);
            String dlpath = context.getCacheDir().getAbsolutePath();
            File file = new File(dlpath, filename);
            if (file.exists()) {
                FileInputStream file_stream = null;
                try {
                    file_stream = new FileInputStream(file);
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }

                if (file_stream != null) {
                    BufferedInputStream buffer = new BufferedInputStream(file_stream);
                    bitmap = BitmapFactory.decodeStream(buffer);

                    try {
                        buffer.close();
                        file_stream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return bitmap;
    }

}
