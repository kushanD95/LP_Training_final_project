package lk.sanuka.mobilegaragesystem.driverservice.service.serviceimpl;

import lk.sanuka.mobilegaragesystem.driverservice.repository.DriverRepository;
import lk.sanuka.mobilegaragesystem.driverservice.service.DriverService;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.exceptions.DriverDetailsNotFoundException;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.exceptions.InvalidDriverDetailsException;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.model.driver.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DriverServiceImpl implements DriverService {

    private String drivingLicenceExpression = "[A-Z]{1}[0-9]{7}";

    @Autowired
    DriverRepository driverRepository;

    @Override
    public Driver save(Driver driver) throws InvalidDriverDetailsException {
        if(!driverValidate(driver)) {
            Driver driver1 = driverRepository.save(driver);
            return driver1;
        } else {
            throw new InvalidDriverDetailsException("Driver Details are Invalid");
        }
    }

    @Override
    public Optional<Driver> findById(int id) throws DriverDetailsNotFoundException, InvalidDriverDetailsException {
        if (id > 0 ) {
            Optional<Driver> foundDriver = driverRepository.findById(id);
            if (foundDriver.isPresent()) {
                return foundDriver;
            } else {
                throw new DriverDetailsNotFoundException("Driver details not found!" + " id: " + id);
            }
        }else {
            throw new InvalidDriverDetailsException("Driver id not valid!" + " id: " + id);
        }
    }

    @Override
    public Optional<Driver> delete(int id) throws DriverDetailsNotFoundException, InvalidDriverDetailsException {
        Optional<Driver> selectedDriverForDelete = this.findById(id);
        if(selectedDriverForDelete.isPresent()) {
            driverRepository.delete(selectedDriverForDelete.get());
            return selectedDriverForDelete;
        } else {
            throw new DriverDetailsNotFoundException("Driver details not found!" + " id: " + id);
        }
    }

    @Override
    public Driver update(Driver driver) throws DriverDetailsNotFoundException, InvalidDriverDetailsException {
        findById(driver.getId());
        return save(driver);

    }

    @Override
    public Set<Driver> findUnapprovedDrivers() throws DriverDetailsNotFoundException {

           Set<Driver> unapprovedDrivers = this.driverRepository.getUnapprovedDrivers();

           if(unapprovedDrivers != null) {
               return unapprovedDrivers;
           } else {
               throw new DriverDetailsNotFoundException("Unapproved Drivers are not found!");
           }
    }

    private boolean driverValidate(Driver driver) {
//        boolean isInvalid =true;
//        Pattern pattern = Pattern.compile(this.drivingLicenceExpression);
//        if(pattern.matcher(driver.getLicenceNo()))
        return false;
    }
}
