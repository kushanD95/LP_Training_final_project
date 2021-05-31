package lk.sanuka.mobilegaragesystem.reportservice.repository;

import lk.sanuka.mobilegaragesystem.servicecloudmodel.model.report.Evidence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvidenceRepository extends JpaRepository<Evidence,Integer> {
}
