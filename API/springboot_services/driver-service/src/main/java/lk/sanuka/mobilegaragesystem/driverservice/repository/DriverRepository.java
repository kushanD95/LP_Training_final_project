package lk.sanuka.mobilegaragesystem.driverservice.repository;

import lk.sanuka.mobilegaragesystem.servicecloudmodel.model.driver.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface DriverRepository extends JpaRepository<Driver,Integer> {
    @Query(value = "select * from Driver where isApproved = false",nativeQuery = true)
    Set<Driver> getUnapprovedDrivers();
}
