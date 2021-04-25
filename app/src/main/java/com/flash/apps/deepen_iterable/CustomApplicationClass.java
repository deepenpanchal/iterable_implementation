package com.flash.apps.deepen_iterable;

import android.app.Application;

import com.iterable.iterableapi.IterableApi;
import com.iterable.iterableapi.IterableConfig;

public class CustomApplicationClass extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        IterableConfig config = new IterableConfig.Builder().build();
        IterableApi.initialize(this, "349dcc9373c74c6699c5d1204a271695", config);
        IterableApi.getInstance().setEmail("deepenpanchal@gmail.com");
        IterableApi.getInstance().registerForPush();
        System.out.println("Iterable - SDK initialized");
    }
}
