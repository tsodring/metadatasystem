package metasystem.controller;

import metasystem.model.OrganisationArea;
import metasystem.service.interfaces.IOrganisationAreaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

import static metasystem.utils.Constants.*;


@RestController
@RequestMapping(value = SLASH + ORGANISATION_AREA)
public class OrganisationAreaController {

    private IOrganisationAreaService organisationAreaService;

    OrganisationAreaController(IOrganisationAreaService organisationAreaService) {
        this.organisationAreaService = organisationAreaService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<OrganisationArea>> getOrganisationAreas() {
        return new ResponseEntity<>
                (organisationAreaService.findAll(), HttpStatus.OK);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<OrganisationArea>
    getOrganisationArea(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(organisationAreaService.findById(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<OrganisationArea> saveOrganisationArea(
            @RequestBody OrganisationArea organisationArea) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(organisationAreaService.save(organisationArea));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<OrganisationArea> updateOrganisationArea(
            @PathVariable("id") Long id,
            @RequestBody OrganisationArea organisationArea)
            throws EntityNotFoundException {
        return ResponseEntity.status(HttpStatus.OK)
                .body(organisationAreaService.update(id, organisationArea));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteOrganisationArea(@PathVariable Long id) {
        organisationAreaService.delete(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body("OrganisationArea with id " + id + " was deleted");
    }
}

