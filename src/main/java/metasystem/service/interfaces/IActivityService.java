package metasystem.service.interfaces;

import metasystem.model.Activity;
import java.util.Set;

/**
 * Created by tsodring on 10/28/17.
 */
public interface IActivityService {
    Iterable<Activity> findAll();
    Activity findById(Long id);
    Activity save(Activity  activity);
    Activity update(Long id, Activity  activity);
    void delete(Long id);
}
