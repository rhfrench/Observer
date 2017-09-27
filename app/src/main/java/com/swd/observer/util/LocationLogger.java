package com.swd.observer.util;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.HandlerThread;
import android.provider.Settings;
import android.support.v4.content.ContextCompat;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.swd.observer.App;
import com.swd.observer.di.AppModule;
import com.swd.observer.models.EventType;

import javax.inject.Inject;


/**
 * Created by Ryan on 9/24/2017.
 */

public class LocationLogger implements LocationListener, ILocationLogger
{
    public String DeviceID;
    public long LogInterval;
    public Location LastSavedLoc;
    public Date LastSavedLogTime;
    public Date OverrideLogTime;
    public EventType EventType;
    private HandlerThread handlerThread;
    private final LocationManager locMngr;
    private final String locProvider;
    private final Criteria locCriteria;

    //region Properties

    public com.swd.observer.models.EventType getEventType() {
        return EventType;
    }

    public void setEventType(com.swd.observer.models.EventType eventType) {
        EventType = eventType;
    }

    public long getLogInterval() {
        return LogInterval;
    }

    public void setLogInterval(long locInterval) {
        LogInterval = locInterval;
    }

    public Date getOverrideLogTime() {
        return OverrideLogTime;
    }

    public void setOverrideLogTime(Date overrideLogTime) {
        OverrideLogTime = overrideLogTime;
    }

    public Date getLastSavedLogTime() {
        return LastSavedLogTime;
    }

    public void setLastSavedLogTime(Date lastSavedLogTime) {
        LastSavedLogTime = lastSavedLogTime;
    }

    public Location getLastSavedLoc() {
        return LastSavedLoc;
    }

    private void setLastSavedLoc(Location lastSavedLoc) {
        this.LastSavedLoc = lastSavedLoc;
    }

    public String getDeviceID() {
        return this.DeviceID;
    }

    public void setDeviceID(String deviceID) {
        this.DeviceID = deviceID;
    }

    //endregion


    @Inject
    Context context;

    //region Constructor
    public LocationLogger()
    {
        this.locMngr = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        Criteria criteriaForLocationService = new Criteria();
        criteriaForLocationService.setAccuracy(Criteria.ACCURACY_FINE);
        this.locCriteria = criteriaForLocationService;
        List<String> acceptableLocationProviders = this.locMngr.getProviders(this.locCriteria, true);

        if (acceptableLocationProviders.size() > 0)
            this.locProvider = acceptableLocationProviders.get(0);
        else
            this.locProvider = "";
    }
    //endregion


    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }

    @Override
    public void RequestSingleLocationUpdate()
    {
        //Run single updates on main looper
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)
            this.locMngr.requestSingleUpdate(this.locCriteria, this, null);
    }

    @Override
    public void StartRequestingUpdates()
    {
        long interval;

        if (ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)
        {
            interval = TimeUnit.MILLISECONDS.toMinutes(this.LogInterval);
            EventType = EventType.Log;
            this.locMngr.removeUpdates(this);
            if (this.handlerThread != null)
            {
                this.handlerThread.quit();
                this.handlerThread = null;
            }

            this.handlerThread = new HandlerThread("LocationLoggerThread", 0);//TODO: research android's thread priority enum
        }
    }

    private String GetID()
    {
        String ID = "";
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED);
            ID = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);

        return ID;
    }

    @Override
    public void StopUpdates()
    {
        this.locMngr.removeUpdates(this);
        if (this.handlerThread != null)
        {
            this.handlerThread.quit();
            this.handlerThread.interrupt();
            this.handlerThread = null;
        }
    }
}
