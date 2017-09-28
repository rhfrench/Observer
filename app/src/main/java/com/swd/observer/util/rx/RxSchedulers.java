package com.swd.observer.util.rx;


import io.reactivex.Scheduler;

/**
 * Created by Ryan on 9/28/2017.
 */

public interface RxSchedulers
{
    Scheduler runOnBackground();
    Scheduler io();
    Scheduler compute();
    Scheduler uiThread();
    Scheduler internet();
}
