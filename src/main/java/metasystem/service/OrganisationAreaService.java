package metasystem.service;

import metasystem.model.OrganisationArea;
import metasystem.persistence.IOrganisationAreaRepository;
import metasystem.service.interfaces.IOrganisationAreaService;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

@Component
@Transactional
public class OrganisationAreaService
    implements IOrganisationAreaService {

    IOrganisationAreaRepository organisationAreaRepository;

    public OrganisationAreaService(IOrganisationAreaRepository organisationAreaRepository) {
        this.organisationAreaRepository = organisationAreaRepository;
    }

    @Override
    public Iterable<OrganisationArea> findAll() {
        return organisationAreaRepository.findAll();
    }

    @Override
    public OrganisationArea findById(Long id) {
        return getOrganisationAreaOrThrow(id);
    }

    @Override
    public OrganisationArea save(OrganisationArea organisationArea) {
        return organisationAreaRepository.save(organisationArea);
    }

    @Override
    public OrganisationArea update(Long id, OrganisationArea organisationArea) {
        OrganisationArea originalOrganisationArea = getOrganisationAreaOrThrow(id);
        originalOrganisationArea.setDescription(organisationArea.getDescription());
        originalOrganisationArea.setOrganisationAreaTitle(organisationArea.getOrganisationAreaTitle());
        organisationAreaRepository.save(originalOrganisationArea);
        return originalOrganisationArea;
    }

    @Override
    public void delete(Long id) {
        OrganisationArea organisationArea = getOrganisationAreaOrThrow(id);
        organisationAreaRepository.delete(organisationArea);
    }

    /**
     * Internal helper method. Rather than having a find and try catch in
     * multiple methods, we have it here once. If you call this, be aware
     * that you will only ever get a valid OrganisationArea back. If there is no
     * valid OrganisationArea, a EntityNotFoundException exception is thrown
     *
     * @param id The id of the organisationArea object to retrieve
     * @return the organisationArea object
     */
    private OrganisationArea getOrganisationAreaOrThrow(@NotNull Long id)
            throws EntityNotFoundException {
        return organisationAreaRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(
                                "No OrganisationArea exists with Id " + id));
    }
}
