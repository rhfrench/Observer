package com.swd.observer.di;

import com.swd.observer.util.LocationLogger;

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
