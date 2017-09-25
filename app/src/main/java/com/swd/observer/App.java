package com.swd.observer;

import android.app.Application;

/**
 * Created by Ryan on 9/24/2017.
 */

public class App extends Application
{
    public static MainActivity Context;
    //region Properties
    public static MainActivity getContext() {
        return Context;
    }

    public static void setContext(MainActivity context) {
        Context = context;
    }
    //endregion

    public ConfigManager()
    {
        this.Context = null;
    }
}
