package metasystem.service.interfaces;

import metasystem.model.Organisation;

public interface IOrganisationService {
    Iterable<Organisation> findAll();
    Organisation findById(Long id);
    Organisation save(Organisation  organisation);
    Organisation update(Long id, Organisation  organisation);
    void delete(Long id);
}
