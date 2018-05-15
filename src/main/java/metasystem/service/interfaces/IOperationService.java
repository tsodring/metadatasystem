package metasystem.service.interfaces;

import metasystem.model.Operation;

public interface IOperationService {
    Iterable<Operation> findAll();
    Operation findById(Long id);
    Operation save(Operation  operation);
    Operation update(Long id, Operation  operation);
    void delete(Long id);
}
