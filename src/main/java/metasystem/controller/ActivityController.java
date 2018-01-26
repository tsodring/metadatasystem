
package metasystem.controller;

import metasystem.model.Activity;
import metasystem.service.IActivityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

import static metasystem.utils.Constants.ACTIVITY;
import static metasystem.utils.Constants.SLASH;

/**
 * Created by tsodring on 9/25/17.
 */
@RestController
@RequestMapping(value = SLASH + ACTIVITY)
public class ActivityController {

    private IActivityService activityService;

    public ActivityController(IActivityService activityService) {
        this.activityService = activityService;
    }

    @RequestMapping(value = "/{activityNumber}", method = RequestMethod.GET)
    public ResponseEntity<Activity> getRequirement(@PathVariable
                                                              ("activityNumber")
                                                         Long activityNumber)
            throws IOException {
        Activity activity = activityService.findByActivityId(activityNumber);
        return ResponseEntity.status(HttpStatus.OK)
                .body(activity);
    }

}
