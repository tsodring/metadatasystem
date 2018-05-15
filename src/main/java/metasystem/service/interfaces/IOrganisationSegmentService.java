package metasystem.service.interfaces;

import metasystem.model.OrganisationSegment;

public interface IOrganisationSegmentService {
    Iterable<OrganisationSegment> findAll();
    OrganisationSegment findById(Long id);
    OrganisationSegment save(OrganisationSegment organisationSegment);
    OrganisationSegment update(Long id, OrganisationSegment organisationSegment);
    void delete(Long id);
}
