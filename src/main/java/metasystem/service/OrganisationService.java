package metasystem.service;

import metasystem.model.Organisation;
import metasystem.persistence.IOrganisationRepository;
import metasystem.service.interfaces.IOrganisationService;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

@Component
@Transactional
public class OrganisationService
    implements IOrganisationService {

    IOrganisationRepository organisationRepository;

    public OrganisationService(IOrganisationRepository organisationRepository) {
        this.organisationRepository = organisationRepository;
    }

    @Override
    public Iterable<Organisation> findAll() {
        return organisationRepository.findAll();
    }

    @Override
    public Organisation findById(Long id) {
        return getOrganisationOrThrow(id);
    }

    @Override
    public Organisation save(Organisation organisation) {
        return organisationRepository.save(organisation);
    }

    @Override
    public Organisation update(Long id, Organisation organisation) {
        Organisation originalOrganisation = getOrganisationOrThrow(id);
        originalOrganisation.setDescription(organisation.getDescription());
        originalOrganisation.setName(organisation.getName());
        organisationRepository.save(originalOrganisation);
        return originalOrganisation;
    }

    @Override
    public void delete(Long id) {
        Organisation organisation = getOrganisationOrThrow(id);
        organisationRepository.delete(organisation);
    }

    /**
     * Internal helper method. Rather than having a find and try catch in
     * multiple methods, we have it here once. If you call this, be aware
     * that you will only ever get a valid Organisation back. If there is no
     * valid Organisation, a EntityNotFoundException exception is thrown
     *
     * @param id The id of the organisation object to retrieve
     * @return the organisation object
     */
    private Organisation getOrganisationOrThrow(@NotNull Long id)
            throws EntityNotFoundException {
        return organisationRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(
                                "No Organisation exists with Id " + id));
    }
}
