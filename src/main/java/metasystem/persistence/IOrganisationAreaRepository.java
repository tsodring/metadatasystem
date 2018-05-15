package metasystem.persistence;

import metasystem.model.OrganisationArea;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrganisationAreaRepository
        extends CrudRepository<OrganisationArea, Long> {
}
