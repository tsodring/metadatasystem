package metasystem.controller;

import metasystem.model.OrganisationSegment;
import metasystem.service.interfaces.IOrganisationSegmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

import static metasystem.utils.Constants.ORGANISATION_AREA;
import static metasystem.utils.Constants.ORGANISATION_SEGMENT;
import static metasystem.utils.Constants.SLASH;


@RestController
@RequestMapping(value = SLASH + ORGANISATION_SEGMENT)
public class OrganisationSegmentController {

    private IOrganisationSegmentService organisationSegmentService;

    OrganisationSegmentController(IOrganisationSegmentService organisationSegmentService) {
        this.organisationSegmentService = organisationSegmentService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<OrganisationSegment>> getOrganisationSegments() {
        return new ResponseEntity<>
                (organisationSegmentService.findAll(), HttpStatus.OK);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<OrganisationSegment>
    getOrganisationSegment(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(organisationSegmentService.findById(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<OrganisationSegment> saveOrganisationSegment(
            @RequestBody OrganisationSegment organisationSegment) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(organisationSegmentService.save(organisationSegment));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<OrganisationSegment> updateOrganisationSegment(
            @PathVariable("id") Long id,
            @RequestBody OrganisationSegment organisationSegment)
            throws EntityNotFoundException {
        return ResponseEntity.status(HttpStatus.OK)
                .body(organisationSegmentService.update(id, organisationSegment));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteOrganisationSegment(@PathVariable Long id) {
        organisationSegmentService.delete(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body("OrganisationSegment with id " + id + " was deleted");
    }
}

