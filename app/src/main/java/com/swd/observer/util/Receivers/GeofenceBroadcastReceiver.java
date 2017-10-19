package com.swd.observer.util.Receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;
import com.swd.observer.util.Services.GeofencingIntentService;

import javax.inject.Inject;

/**
 * Created by Ryan on 10/18/2017.
 */

public class GeofenceBroadcastReceiver extends WakefulBroadcastReceiver
{

    @Inject
    Context context;

  public GeofenceBroadcastReceiver()
  {

  }

    @Override
    public void onReceive(Context context, Intent intent)
    {
        Intent serviceItent = new Intent(context, GeofencingIntentService.class);
        serviceItent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        serviceItent.replaceExtras(intent.getExtras());
        serviceItent.setAction(intent.getAction());
        startWakefulService(context, serviceItent);
    }
}
