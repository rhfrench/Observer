package com.swd.observer;

import android.app.Application;
import android.content.Context;

/**
 * Created by Ryan on 9/24/2017.
 */

public class App extends Application
{
    private static App instance;

    public static App getInstance()
    {
        return instance;
    }

    public static Context getContext()
    {
        return instance.getApplicationContext();
    }

    @Override
    public void onCreate()
    {
        instance = this;
        super.onCreate();
    }
}
