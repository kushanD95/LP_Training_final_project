package lk.sanuka.mobilegaragesystem.driverservice.controller;

import javassist.NotFoundException;
import lk.sanuka.mobilegaragesystem.driverservice.service.DriverService;
import lk.sanuka.mobilegaragesystem.driverservice.service.VehicleService;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.exceptions.DriverDetailsNotFoundException;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.exceptions.InvalidDriverDetailsException;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.model.driver.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping(value = "/driver")
public class DriverController {

    @Autowired
    DriverService driverService;

    @Autowired
    VehicleService vehicleService;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_admin') || hasRole('ROLE_driver')")
    public ResponseEntity<Driver> save(@RequestBody Driver driver) {
        ResponseEntity<Driver> responseEntity;

        try{
            responseEntity = new ResponseEntity(driverService.save(driver), HttpStatus.OK);
        } catch (InvalidDriverDetailsException e) {
            responseEntity = new ResponseEntity(e,HttpStatus.SERVICE_UNAVAILABLE);
            System.err.print(e.getMessage());
        }

        return responseEntity;
    }

    @GetMapping(value = "/{id}")
    @PreAuthorize("hasRole('ROLE_admin') || hasRole('ROLE_driver')")
    public ResponseEntity<Driver> findById(@PathVariable("id") int id) throws NotFoundException {
        ResponseEntity<Driver> responseEntity;

        try{
            Optional<Driver> selectedDriver = driverService.findById(id);
            selectedDriver.get().setVehicles(vehicleService.getDriversVehicles(id));

            responseEntity = new ResponseEntity(selectedDriver.get(), HttpStatus.OK);
        } catch (InvalidDriverDetailsException e) {
            responseEntity = new ResponseEntity(e,HttpStatus.SERVICE_UNAVAILABLE);
            System.err.print(e.getMessage());
        } catch (DriverDetailsNotFoundException e) {
            throw new NotFoundException(e.getMessage());
            //responseEntity = new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }

        return responseEntity;

    }

    @PutMapping(value = "/{id}")
    @PreAuthorize("hasRole('ROLE_admin') || hasRole('ROLE_driver')")
    public ResponseEntity<Driver> update(@RequestBody Driver driver) {
        ResponseEntity<Driver> responseEntity;

        try{
            responseEntity = new ResponseEntity(driverService.update(driver), HttpStatus.OK);
        } catch (InvalidDriverDetailsException e) {
            responseEntity = new ResponseEntity(e,HttpStatus.SERVICE_UNAVAILABLE);
            System.err.print(e.getMessage());
        } catch (DriverDetailsNotFoundException e) {
            responseEntity = new ResponseEntity(e,HttpStatus.NOT_FOUND);
        }

        return responseEntity;
    }

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasRole('ROLE_admin') || hasRole('ROLE_driver')")
    public ResponseEntity<Driver> delete(@PathVariable("id") int id) {
        ResponseEntity<Driver> responseEntity;

        try{
            responseEntity = new ResponseEntity(driverService.delete(id),HttpStatus.OK);
        } catch (InvalidDriverDetailsException e) {
            responseEntity = new ResponseEntity(e,HttpStatus.SERVICE_UNAVAILABLE);
            System.err.print(e.getMessage());
        } catch (DriverDetailsNotFoundException e) {
            responseEntity = new ResponseEntity(e,HttpStatus.NOT_FOUND);
        }

        return responseEntity;

    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_admin') || hasRole('ROLE_driver')")
    public ResponseEntity<Set<Driver>> findUnapprovedDrivers (){
        ResponseEntity<Set<Driver>> responseEntity;

        try{
            responseEntity = new ResponseEntity(driverService.findUnapprovedDrivers(), HttpStatus.OK);
        } catch (DriverDetailsNotFoundException e) {
            responseEntity = new ResponseEntity(e,HttpStatus.NOT_FOUND);
        }

        return responseEntity;

    }
}
