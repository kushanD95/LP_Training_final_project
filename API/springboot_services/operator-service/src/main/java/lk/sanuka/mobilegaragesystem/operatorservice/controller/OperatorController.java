package lk.sanuka.mobilegaragesystem.operatorservice.controller;

import lk.sanuka.mobilegaragesystem.operatorservice.service.OperatorService;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.exceptions.InvalidOperatorDetailsException;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.exceptions.OperatorDetailsNotFoundException;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.model.operator.Operator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(value = "/operator")
public class OperatorController {
    @Autowired
    OperatorService operatorService;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_admin') || hasRole('ROLE_operator')")
    public ResponseEntity<Operator> save(@RequestBody Operator operator) {
        ResponseEntity<Operator> responseEntity;

        try{
            responseEntity = new ResponseEntity(operatorService.save(operator), HttpStatus.OK);
        } catch (InvalidOperatorDetailsException e) {
            responseEntity = new ResponseEntity(e,HttpStatus.SERVICE_UNAVAILABLE);
            System.err.print(e.getMessage());
        }

        return responseEntity;
    }

    @GetMapping(value = "/{id}")
    @PreAuthorize("hasRole('ROLE_admin') || hasRole('ROLE_operator')")
    public ResponseEntity<Operator> findById(@PathVariable("id") int id) {
        ResponseEntity<Operator> responseEntity;

        try{
            responseEntity = new ResponseEntity(operatorService.findById(id), HttpStatus.OK);
        } catch (InvalidOperatorDetailsException e) {
            responseEntity = new ResponseEntity(e,HttpStatus.SERVICE_UNAVAILABLE);
            System.err.print(e.getMessage());
        } catch (OperatorDetailsNotFoundException e) {
            responseEntity = new ResponseEntity(e,HttpStatus.NOT_FOUND);
        }

        return responseEntity;

    }

    @PutMapping(value = "/{id}")
    @PreAuthorize("hasRole('ROLE_admin') || hasRole('ROLE_operator')")
    public ResponseEntity<Operator> update(@RequestBody Operator operator) {
        ResponseEntity<Operator> responseEntity;

        try{
            responseEntity = new ResponseEntity(operatorService.update(operator), HttpStatus.OK);
        } catch (InvalidOperatorDetailsException e) {
            responseEntity = new ResponseEntity(e,HttpStatus.SERVICE_UNAVAILABLE);
            System.err.print(e.getMessage());
        } catch (OperatorDetailsNotFoundException e) {
            responseEntity = new ResponseEntity(e,HttpStatus.NOT_FOUND);
        }

        return responseEntity;
    }

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasRole('ROLE_admin') || hasRole('ROLE_operator')")
    public ResponseEntity<Operator> delete(@PathVariable("id") int id) {
        ResponseEntity<Operator> responseEntity;

        try{
            responseEntity = new ResponseEntity(operatorService.delete(id),HttpStatus.OK);
        } catch (InvalidOperatorDetailsException e) {
            responseEntity = new ResponseEntity(e,HttpStatus.SERVICE_UNAVAILABLE);
            System.err.print(e.getMessage());
        } catch (OperatorDetailsNotFoundException e) {
            responseEntity = new ResponseEntity(e,HttpStatus.NOT_FOUND);
        }

        return responseEntity;

    }

    @GetMapping(value = "/unapprovedOperators")
    @PreAuthorize("hasRole('ROLE_admin')")
    public Set<Operator> getUnapprovedOperators() {
        return operatorService.getUnapprovedOperators();
    }
}
