package metasystem.service;

import metasystem.model.Activity;
import metasystem.persistence.IActivityRepository;
import metasystem.service.interfaces.IActivityService;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

@Component
@Transactional
public class ActivityService
    implements IActivityService {

    IActivityRepository activityRepository;

    public ActivityService(IActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    @Override
    public Iterable<Activity> findAll() {
        return activityRepository.findAll();
    }

    @Override
    public Activity findById(Long id) {
        return getActivityOrThrow(id);
    }

    @Override
    public Activity save(Activity activity) {
        return activityRepository.save(activity);
    }

    @Override
    public Activity update(Long id, Activity activity) {
        Activity originalActivity = getActivityOrThrow(id);
        originalActivity.setActivityDescription(activity.getActivityDescription());
        originalActivity.setTitle(activity.getTitle());
        originalActivity.setAnalogueDocumentFormat(activity.getAnalogueDocumentFormat());
        originalActivity.setDeletionRetentionDeadline(activity.getDeletionRetentionDeadline());
        originalActivity.setAnalogueDocumentStorage(activity.getAnalogueDocumentStorage());
        activityRepository.save(originalActivity);
        return originalActivity;
    }

    @Override
    public void delete(Long id) {
        Activity activity = getActivityOrThrow(id);
        activityRepository.delete(activity);
    }

    /**
     * Internal helper method. Rather than having a find and try catch in
     * multiple methods, we have it here once. If you call this, be aware
     * that you will only ever get a valid Activity back. If there is no
     * valid Activity, a EntityNotFoundException exception is thrown
     *
     * @param id The id of the activity object to retrieve
     * @return the activity object
     */
    private Activity getActivityOrThrow(@NotNull Long id)
            throws EntityNotFoundException {
        return activityRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(
                                "No Activity exists with Id " + id));
    }
}
