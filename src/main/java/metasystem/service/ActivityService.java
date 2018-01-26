package metasystem.service;

import metasystem.model.Activity;
import metasystem.persistence.IActivityRepository;
import org.springframework.stereotype.Component;
import java.util.Set;

/**
 * Created by tsodring on 10/28/17.
 */
@Component
public class ActivityService implements IActivityService {

    private IActivityRepository activityRepository;

    public ActivityService(IActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    @Override
    public Activity save(Activity activity) {
        return activityRepository.save(activity);
    }

    @Override
    public Set<Activity> findAll() {
        return activityRepository.findAll();
    }

    @Override
    public Activity findByActivityName(String activityName) {
        return activityRepository.findByActivityName(activityName);
    }

    @Override
    public Activity findByActivityId(Long activityId) {
        return activityRepository.findByActivityId(activityId);
    }
}
