package lk.sanuka.mobilegaragesystem.reportservice.service;

import lk.sanuka.mobilegaragesystem.servicecloudmodel.exceptions.InvalidReportException;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.exceptions.ReportDetailsNotFoundException;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.model.report.Report;

public interface ReportService {
    Report save(Report report) throws InvalidReportException;

    Report findById(int id) throws ReportDetailsNotFoundException, InvalidReportException;

    Report delete(int id) throws ReportDetailsNotFoundException, InvalidReportException;
}
