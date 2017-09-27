package com.swd.observer.di;

import com.swd.observer.ui.DashboardActivity;
import com.swd.observer.util.LocationLogger;
import com.swd.observer.util.ObserverService;

import javax.inject.Singleton;
import dagger.Component;

/**
 * Created by Ryan on 9/27/2017.
 */

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent
{
    void inject(LocationLogger target);
}
