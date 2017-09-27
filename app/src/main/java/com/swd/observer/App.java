package com.swd.observer;

import android.app.Application;
import com.swd.observer.di.AppComponent;
import com.swd.observer.di.AppModule;
import com.swd.observer.di.DaggerAppComponent;

/**
 * Created by Ryan on 9/27/2017.
 */

public class App extends Application
{
    private static AppComponent appComponent;

    //region Properties
    public static AppComponent getAppComponent() {
        return appComponent;
    }

    public void setAppComponent(AppComponent appComponent) {
        this.appComponent = appComponent;
    }
    //endregion

    protected AppComponent initDagger(App application)
    {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(application))
                .build();
    }

    @Override
    public void onCreate()
    {
        super.onCreate();
        this.appComponent = initDagger(this);
    }
}
