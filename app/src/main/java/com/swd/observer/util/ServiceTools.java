package com.swd.observer.util;


import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Ryan on 9/27/2017.
 */

public class ServiceTools implements IServiceTools
{
    @Inject
    Context mContext;


    @Override
    public boolean CheckServiceStatus()
    {
        boolean found = false;
        ActivityManager mngr = (ActivityManager)mContext.getSystemService(Context.ACTIVITY_SERVICE);
        @SuppressWarnings("deprecation") List<ActivityManager.RunningServiceInfo> services = mngr.getRunningServices(Integer.MAX_VALUE);
        services = getServicesForThisPackage(services);

        for (ActivityManager.RunningServiceInfo info : services)
        {
            if (info.service.getClassName().toUpperCase().equals("COM.SWD.OBSERVER.OBSERVERSERVICE"))
            found = true;
        }

        return found;
    }

    @Override
    public void ShutdownObserverService()
    {

        ActivityManager mngr = (ActivityManager)mContext.getSystemService(Context.ACTIVITY_SERVICE);
        @SuppressWarnings("deprecation") List<ActivityManager.RunningServiceInfo> services = mngr.getRunningServices(Integer.MAX_VALUE);
        services = getServicesForThisPackage(services);

        for (ActivityManager.RunningServiceInfo info : services)
        {
            if (info.service.getClassName().toUpperCase().equals("COM.SWD.OBSERVER.OBSERVERSERVICE"))
            {
                //TODO: force on destroy.
            }
        }
    }

    private List<ActivityManager.RunningServiceInfo> getServicesForThisPackage(List<ActivityManager.RunningServiceInfo> services)
    {
        List<ActivityManager.RunningServiceInfo> observerServices = new ArrayList<ActivityManager.RunningServiceInfo>();

        for (ActivityManager.RunningServiceInfo info : services)
        {
            if (info.service.getPackageName() == "com.swd.observer")
                observerServices.add(info);
        }

        return observerServices;
    }

    @Override
    public void ForceShutdownObserver()
    {
        System.exit(0);
    }

    @Override
    public void CancelNotification() {

    }

    @Override
    public void NotificationInProgress(int total, int progress) {

    }

    @Override
    public void BuildNotification(String message, boolean uploadInProgress) {

    }
}
