package com.swd.observer.util.Services;

/**
 * Created by Ryan on 9/21/2017.
 */

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.swd.observer.util.IServiceTools;

public class ObserverService extends Service
{
    private volatile boolean isGPSEnabled;
    private IServiceTools serviceTools;

    public ObserverService()
    {

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent)
    {
        return null;
    }
}
