package metasystem.persistence;

import metasystem.model.Activity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface IActivityRepository extends CrudRepository<Activity, Long> {

    @Override
    Activity save(Activity activity);

    @Override
    Set<Activity> findAll();

    // activityName
    Activity findByActivityName(String activityName);

    // activityId
    Activity findByActivityId(Long activityId);

}
