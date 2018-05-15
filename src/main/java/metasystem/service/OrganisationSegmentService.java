package metasystem.service;

import metasystem.model.OrganisationSegment;
import metasystem.persistence.IOrganisationSegmentRepository;
import metasystem.service.interfaces.IOrganisationSegmentService;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

@Component
@Transactional
public class OrganisationSegmentService
    implements IOrganisationSegmentService {

    IOrganisationSegmentRepository organisationSegmentRepository;

    public OrganisationSegmentService(IOrganisationSegmentRepository organisationSegmentRepository) {
        this.organisationSegmentRepository = organisationSegmentRepository;
    }

    @Override
    public Iterable<OrganisationSegment> findAll() {
        return organisationSegmentRepository.findAll();
    }

    @Override
    public OrganisationSegment findById(Long id) {
        return getOrganisationSegmentOrThrow(id);
    }

    @Override
    public OrganisationSegment save(OrganisationSegment organisationSegment) {
        return organisationSegmentRepository.save(organisationSegment);
    }

    @Override
    public OrganisationSegment update(Long id, OrganisationSegment organisationSegment) {
        OrganisationSegment originalOrganisationSegment = getOrganisationSegmentOrThrow(id);
        originalOrganisationSegment.setDescription(organisationSegment.getDescription());
        originalOrganisationSegment.setOrganisationSegmentTitle
                (organisationSegment.getOrganisationSegmentTitle());
        organisationSegmentRepository.save(originalOrganisationSegment);
        return originalOrganisationSegment;
    }

    @Override
    public void delete(Long id) {
        OrganisationSegment organisationSegment = getOrganisationSegmentOrThrow(id);
        organisationSegmentRepository.delete(organisationSegment);
    }

    /**
     * Internal helper method. Rather than having a find and try catch in
     * multiple methods, we have it here once. If you call this, be aware
     * that you will only ever get a valid OrganisationSegment back. If there is no
     * valid OrganisationSegment, a EntityNotFoundException exception is thrown
     *
     * @param id The id of the organisationSegment object to retrieve
     * @return the organisationSegment object
     */
    private OrganisationSegment getOrganisationSegmentOrThrow(@NotNull Long id)
            throws EntityNotFoundException {
        return organisationSegmentRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(
                                "No OrganisationSegment exists with Id " + id));
    }
}
