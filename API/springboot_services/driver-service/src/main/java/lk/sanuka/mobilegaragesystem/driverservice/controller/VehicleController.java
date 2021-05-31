package lk.sanuka.mobilegaragesystem.driverservice.controller;

import lk.sanuka.mobilegaragesystem.driverservice.service.VehicleService;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.exceptions.InvalidDriverDetailsException;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.model.driver.Driver;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.model.driver.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/vehicle")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_admin') || hasRole('ROLE_driver')")
    public ResponseEntity<Vehicle> save(@RequestBody Vehicle vehicle) {
        ResponseEntity<Vehicle> responseEntity;

        try{
            responseEntity = new ResponseEntity(vehicleService.save(vehicle), HttpStatus.OK);
        } catch (InvalidDriverDetailsException e) {
            responseEntity = new ResponseEntity(e.getMessage(),HttpStatus.SERVICE_UNAVAILABLE);
            System.err.print(e.getMessage());
        }

        return responseEntity;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('read_profile')")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable("id") int id) {
        ResponseEntity<Vehicle> responseEntity;
        try {
            responseEntity = new ResponseEntity(vehicleService.getVehicleDetails(id), HttpStatus.OK);
        } catch (Exception e) {
            responseEntity =new ResponseEntity(e.getMessage(),HttpStatus.SERVICE_UNAVAILABLE);
        }
        return responseEntity;
    }
}
