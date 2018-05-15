package metasystem.controller;

import metasystem.model.Operation;
import metasystem.service.interfaces.IOperationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

import static metasystem.utils.Constants.OPERATION;
import static metasystem.utils.Constants.SLASH;


@RestController
@RequestMapping(value = SLASH + OPERATION)
public class OperationController {

    private IOperationService operationService;

    OperationController(IOperationService operationService) {
        this.operationService = operationService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Operation>> getOperations() {
        return new ResponseEntity<>
                (operationService.findAll(), HttpStatus.OK);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Operation>
    getOperation(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(operationService.findById(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Operation> saveOperation(
            @RequestBody Operation operation) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(operationService.save(operation));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Operation> updateOperation(
            @PathVariable("id") Long id,
            @RequestBody Operation operation)
            throws EntityNotFoundException {
        return ResponseEntity.status(HttpStatus.OK)
                .body(operationService.update(id, operation));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteOperation(@PathVariable Long id) {
        operationService.delete(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Operation with id " + id + " was deleted");
    }
}

