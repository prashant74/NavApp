package com.example.prashant.snapbug;

import android.app.Application;
import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import okhttp3.OkHttpClient;

/**
 * Created by prashant on 7/1/16.
 */
public class NavApp extends Application {
  public void onCreate() {
    super.onCreate();
    Stetho.initializeWithDefaults(this);
    new OkHttpClient.Builder().addNetworkInterceptor(new StethoInterceptor()).build();
  }
}
