package com.chengyu.wellsjd;

import android.app.Application;

import com.chengyu.latte.app.Latte;

public class ExampleApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withApiHost("")
                .configure();
    }
}
