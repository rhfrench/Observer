package Service;

/**
 * Created by Ryan on 9/24/2017.
 */

public interface ILocationLogger
{
    void RequestSingleLocationUpdate();
    void StartRequestingUpdates();
    void StopUpdates();
}
