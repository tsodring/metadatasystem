package metasystem.controller;

import metasystem.model.Activity;
import metasystem.service.interfaces.IActivityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

import static metasystem.utils.Constants.ACTIVITY;
import static metasystem.utils.Constants.SLASH;


@RestController
@RequestMapping(value = SLASH + ACTIVITY)
public class ActivityController {

    private IActivityService activityService;

    ActivityController(IActivityService activityService) {
        this.activityService = activityService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Activity>> getActivitys() {
        return new ResponseEntity<>
                (activityService.findAll(), HttpStatus.OK);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Activity>
    getActivity(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(activityService.findById(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Activity> saveActivity(
            @RequestBody Activity activity) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(activityService.save(activity));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Activity> updateActivity(
            @PathVariable("id") Long id,
            @RequestBody Activity activity)
            throws EntityNotFoundException {
        return ResponseEntity.status(HttpStatus.OK)
                .body(activityService.update(id, activity));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteActivity(@PathVariable Long id) {
        activityService.delete(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Activity with id " + id + " was deleted");
    }
}

