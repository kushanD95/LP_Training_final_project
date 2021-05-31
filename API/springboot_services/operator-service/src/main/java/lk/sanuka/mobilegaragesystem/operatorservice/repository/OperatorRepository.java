package lk.sanuka.mobilegaragesystem.operatorservice.repository;

import lk.sanuka.mobilegaragesystem.servicecloudmodel.model.operator.Operator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface OperatorRepository extends JpaRepository<Operator,Integer> {

    @Query(value = "select * from Operator where isApproved == false", nativeQuery = true)
    Set<Operator> getUnapprovedOperators();
}
