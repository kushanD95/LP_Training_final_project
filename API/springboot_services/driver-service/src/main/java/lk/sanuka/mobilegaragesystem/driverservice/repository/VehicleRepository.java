package lk.sanuka.mobilegaragesystem.driverservice.repository;

import lk.sanuka.mobilegaragesystem.servicecloudmodel.model.driver.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface VehicleRepository extends JpaRepository<Vehicle,Integer> {

    @Query(value = "select * from Vehicle where driver_id = :driverId",nativeQuery = true)
    Set<Vehicle> getDriversVehicle(@Param("driverId")int driverId);
}
