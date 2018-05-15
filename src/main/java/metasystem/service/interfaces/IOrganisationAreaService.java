package metasystem.service.interfaces;

import metasystem.model.OrganisationArea;

public interface IOrganisationAreaService {
    Iterable<OrganisationArea> findAll();
    OrganisationArea findById(Long id);
    OrganisationArea save(OrganisationArea  organisationArea);
    OrganisationArea update(Long id, OrganisationArea  organisationArea);
    void delete(Long id);
}
