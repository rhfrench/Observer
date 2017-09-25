package com.swd.observer;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.HandlerThread;
import java.util.Date;
import java.util.Scanner;
import java.util.*;
import android.location.Criteria;



/**
 * Created by Ryan on 9/24/2017.
 */

public class LocationLogger implements LocationListener, ILocationLogger
{
    public String DeviceID;
    public Location LastSavedLoc;
    public Date LastSavedLogTime;
    public Date OverrideLogTime;
    private HandlerThread handlerThread;
    private final LocationManager locMngr;
    private final String locProvider;
    private final Criteria locCriteria;

    //region Properties
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


    //region Constructor
    public LocationLogger()
    {
        this.locMngr = (LocationManager)App.getContext().getSystemService(Context.LOCATION_SERVICE);
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

    }

    @Override
    public void StartRequestingUpdates()
    {

    }

    @Override
    public void StopUpdates()
    {
        this.locMngr.removeUpdates(this);

    }
}
