package com.swd.observer.util.rx;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Ryan on 9/28/2017.
 */

public class AppRxSchedulers implements  IRxSchedulers
{
    public static Executor backgroundExecutor = Executors.newCachedThreadPool();
    public static Scheduler BACKGROUND_SCHEDULERS = Schedulers.from(backgroundExecutor);
    public static Executor internetExecutor = Executors.newCachedThreadPool();
    public static Scheduler INTERNET_SCHEDULERS = Schedulers.from(internetExecutor);

    @Override
    public Scheduler runOnBackground() {
        return BACKGROUND_SCHEDULERS;
    }

    @Override
    public Scheduler io() {
        return Schedulers.io();
    }

    @Override
    public Scheduler compute() {
        return Schedulers.computation();
    }

    @Override
    public Scheduler uiThread() {
        return AndroidSchedulers.mainThread();
    }

    @Override
    public Scheduler internet() {
        return INTERNET_SCHEDULERS;
    }

    @Override
    public Scheduler newThread() {
        return Schedulers.newThread();
    }
}
