package lk.sanuka.mobilegaragesystem.driverservice.service.serviceimpl;

import lk.sanuka.mobilegaragesystem.driverservice.repository.VehicleRepository;
import lk.sanuka.mobilegaragesystem.driverservice.service.VehicleService;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.exceptions.DriverDetailsNotFoundException;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.exceptions.InvalidDriverDetailsException;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.model.driver.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;
import java.util.Set;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    @Override
    public Vehicle save(Vehicle vehicle) throws InvalidDriverDetailsException {

        if(isValid(vehicle)) {
            return vehicleRepository.save(vehicle);
        } else {
            throw new InvalidDriverDetailsException("vehicle details are invalid");
        }
    }

    @Override
    public Optional<Vehicle> getVehicleDetails(int id) throws DriverDetailsNotFoundException, InvalidDriverDetailsException {
        if(id > 0) {
            Optional<Vehicle> fetchedVehicle = vehicleRepository.findById(id);

            if(fetchedVehicle.isPresent()) {
                return fetchedVehicle;
            } else {
                throw new DriverDetailsNotFoundException("Vehicle is not found! - id " + id);
            }
        } else {
            throw new InvalidDriverDetailsException("Vehicle details are invalid !");
        }
    }

    @Override
    public Set<Vehicle> getDriversVehicles(int driverId) throws DriverDetailsNotFoundException {
        if(driverId > 0) {
            Set<Vehicle> driverVehicles;
            driverVehicles = vehicleRepository.getDriversVehicle(driverId);
            return driverVehicles;
        } else {
            throw new DriverDetailsNotFoundException("No records of Driver vehicles - Driver id " + driverId);
        }
    }

    private boolean isValid(Vehicle vehicle) {
        return true;
    }
}
