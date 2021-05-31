package lk.sanuka.mobilegaragesystem.reportservice.repository;

import lk.sanuka.mobilegaragesystem.servicecloudmodel.model.report.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report,Integer> {
}
