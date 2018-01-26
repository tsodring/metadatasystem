package metasystem.service;

import metasystem.model.Activity;
import java.util.Set;

/**
 * Created by tsodring on 10/28/17.
 */
public interface IActivityService {
    Activity save(Activity activity);
    Set<Activity> findAll();
    Activity findByActivityName(String activityName);
    Activity findByActivityId(Long activityId);
}
