package metasystem.persistence;


import metasystem.model.Organisation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrganisationRepository
        extends CrudRepository<Organisation, Long> {
}
