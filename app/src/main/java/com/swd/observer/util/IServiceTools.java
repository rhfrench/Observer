package com.swd.observer.util;

/**
 * Created by Ryan on 10/3/2017.
 */

public interface IServiceTools
{
    boolean CheckServiceStatus();
    void ShutdownObserverService();
    void ForceShutdownObserver();
    void CancelNotification();
    void NotificationInProgress(int total, int progress);
    void BuildNotification(String message, boolean uploadInProgress);
}
