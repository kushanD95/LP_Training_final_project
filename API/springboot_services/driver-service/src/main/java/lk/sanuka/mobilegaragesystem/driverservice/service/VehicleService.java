package lk.sanuka.mobilegaragesystem.driverservice.service;

import lk.sanuka.mobilegaragesystem.servicecloudmodel.exceptions.DriverDetailsNotFoundException;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.exceptions.InvalidDriverDetailsException;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.model.driver.Vehicle;

import java.util.Optional;
import java.util.Set;

public interface VehicleService {
    public Vehicle save(Vehicle vehicle) throws InvalidDriverDetailsException;
    public Optional<Vehicle> getVehicleDetails(int id) throws DriverDetailsNotFoundException, InvalidDriverDetailsException;
    public Set<Vehicle> getDriversVehicles(int driverId) throws DriverDetailsNotFoundException;
}
