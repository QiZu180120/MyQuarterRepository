package com.example.menglucywhh.myquarter.applica;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;

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
        //默认的日间模式
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
    }

}
