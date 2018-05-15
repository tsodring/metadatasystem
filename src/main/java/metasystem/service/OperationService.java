package metasystem.service;

import metasystem.model.Operation;
import metasystem.persistence.IOperationRepository;
import metasystem.service.interfaces.IOperationService;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

@Component
@Transactional
public class OperationService
    implements IOperationService {

    IOperationRepository operationRepository;

    public OperationService(IOperationRepository operationRepository) {
        this.operationRepository = operationRepository;
    }

    @Override
    public Iterable<Operation> findAll() {
        return operationRepository.findAll();
    }

    @Override
    public Operation findById(Long id) {
        return getOperationOrThrow(id);
    }

    @Override
    public Operation save(Operation operation) {
        return operationRepository.save(operation);
    }

    @Override
    public Operation update(Long id, Operation operation) {
        Operation originalOperation = getOperationOrThrow(id);
        originalOperation.setDescription(operation.getDescription());
        originalOperation.setOperationTitle(operation.getOperationTitle());
        operationRepository.save(originalOperation);
        return originalOperation;
    }

    @Override
    public void delete(Long id) {
        Operation operation = getOperationOrThrow(id);
        operationRepository.delete(operation);
    }

    /**
     * Internal helper method. Rather than having a find and try catch in
     * multiple methods, we have it here once. If you call this, be aware
     * that you will only ever get a valid Operation back. If there is no
     * valid Operation, a EntityNotFoundException exception is thrown
     *
     * @param id The id of the operation object to retrieve
     * @return the operation object
     */
    private Operation getOperationOrThrow(@NotNull Long id)
            throws EntityNotFoundException {
        return operationRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(
                                "No Operation exists with Id " + id));
    }
}
