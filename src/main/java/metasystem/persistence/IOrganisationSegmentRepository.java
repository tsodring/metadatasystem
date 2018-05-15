package metasystem.persistence;

import metasystem.model.OrganisationSegment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrganisationSegmentRepository
        extends CrudRepository<OrganisationSegment, Long> {
}
