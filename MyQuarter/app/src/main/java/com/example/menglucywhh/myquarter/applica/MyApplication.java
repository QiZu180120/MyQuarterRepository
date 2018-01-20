package com.example.menglucywhh.myquarter.applica;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by Menglucywhh on 2018/1/19.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化Fresco

        Fresco.initialize(this);
    }
}
