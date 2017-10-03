package com.swd.observer.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by Ryan on 10/1/2017.
 */

public class LocationModel implements Parcelable
{
    public int LocationKey;
    public double Longitude;
    public double Latitude;
    public double Speed;
    public Date LogTime;


    public int getLocationKey() {
        return LocationKey;
    }

    public void setLocationKey(int locationKey) {
        LocationKey = locationKey;
    }

    public double getLongitude() {
        return Longitude;
    }

    public void setLongitude(double longitude) {
        Longitude = longitude;
    }

    public double getLatitude() {
        return Latitude;
    }

    public void setLatitude(double latitude) {
        Latitude = latitude;
    }

    public double getSpeed() {
        return Speed;
    }

    public void setSpeed(double speed) {
        Speed = speed;
    }

    public Date getLogTime() {
        return LogTime;
    }

    public void setLogTime(Date logTime) {
        LogTime = logTime;
    }


    protected LocationModel(Parcel in) {
        LocationKey = in.readInt();
        Longitude = in.readDouble();
        Latitude = in.readDouble();
        Speed = in.readDouble();
    }

    public static final Creator<LocationModel> CREATOR = new Creator<LocationModel>() {
        @Override
        public LocationModel createFromParcel(Parcel in) {
            return new LocationModel(in);
        }

        @Override
        public LocationModel[] newArray(int size) {
            return new LocationModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(LocationKey);
        parcel.writeDouble(Longitude);
        parcel.writeDouble(Latitude);
        parcel.writeDouble(Speed);
    }
}
