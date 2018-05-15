package metasystem.controller;

import metasystem.model.Organisation;
import metasystem.service.interfaces.IOrganisationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

import static metasystem.utils.Constants.ORGANISATION;
import static metasystem.utils.Constants.SLASH;


@RestController
@RequestMapping(value = SLASH + ORGANISATION)
public class OrganisationController {

    private IOrganisationService organisationService;

    OrganisationController(IOrganisationService organisationService) {
        this.organisationService = organisationService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Organisation>> getOrganisations() {
        return new ResponseEntity<>
                (organisationService.findAll(), HttpStatus.OK);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Organisation>
    getOrganisation(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(organisationService.findById(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Organisation> saveOrganisation(
            @RequestBody Organisation organisation) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(organisationService.save(organisation));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Organisation> updateOrganisation(
            @PathVariable("id") Long id,
            @RequestBody Organisation organisation)
            throws EntityNotFoundException {
        return ResponseEntity.status(HttpStatus.OK)
                .body(organisationService.update(id, organisation));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteOrganisation(@PathVariable Long id) {
        organisationService.delete(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Organisation with id " + id + " was deleted");
    }
}

