package lk.sanuka.mobilegaragesystem.driverservice.service;

import lk.sanuka.mobilegaragesystem.servicecloudmodel.exceptions.DriverDetailsNotFoundException;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.exceptions.InvalidDriverDetailsException;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.model.driver.Driver;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface DriverService {
    Driver save(Driver driver) throws InvalidDriverDetailsException;

    Optional<Driver> findById(int id) throws DriverDetailsNotFoundException, InvalidDriverDetailsException;

    Optional<Driver> delete(int id) throws DriverDetailsNotFoundException, InvalidDriverDetailsException;

    Driver update(Driver driver) throws DriverDetailsNotFoundException, InvalidDriverDetailsException;

    Set<Driver> findUnapprovedDrivers() throws DriverDetailsNotFoundException;
}
