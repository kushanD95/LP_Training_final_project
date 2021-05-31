package lk.sanuka.mobilegaragesystem.paymentservice.repository;

import lk.sanuka.mobilegaragesystem.servicecloudmodel.model.payment.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {

    @Query(value = "select * from Payment where driver_id = :driverId", nativeQuery = true)
    Set<Payment> findPaymentByDriverId(@Param("driverId")int driverId);

    @Query(value = "select * from Payment where operator_id = :operatorId", nativeQuery = true)
    Set<Payment> findPaymentByOperatorId(@Param("operatorId")int operatorId);
}
