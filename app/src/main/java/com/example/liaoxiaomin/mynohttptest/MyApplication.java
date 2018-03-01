package com.example.liaoxiaomin.mynohttptest;

import android.app.Application;

import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.rest.RequestQueue;

public class MyApplication extends Application {

    public static RequestQueue mQueue=null;
    @Override
    public void onCreate() {
        super.onCreate();
        NoHttp.initialize(this);
        mQueue=NoHttp.newRequestQueue();
    }
}
