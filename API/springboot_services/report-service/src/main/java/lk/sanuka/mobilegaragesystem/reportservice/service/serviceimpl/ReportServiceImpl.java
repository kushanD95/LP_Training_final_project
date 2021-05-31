package lk.sanuka.mobilegaragesystem.reportservice.service.serviceimpl;

import lk.sanuka.mobilegaragesystem.reportservice.repository.ReportRepository;
import lk.sanuka.mobilegaragesystem.reportservice.service.ReportService;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.exceptions.InvalidReportException;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.exceptions.ReportDetailsNotFoundException;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.model.report.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    ReportRepository reportRepository;

    @Override
    public Report save(Report report) throws InvalidReportException {
        if(validate(report)) {
            Report report1 = reportRepository.save(report);
          return report1;
        } else {
            throw new InvalidReportException("Report details are not valid");
        }
    }

    @Override
    public Report findById(int id) throws ReportDetailsNotFoundException, InvalidReportException {
        if (id > 0 ) {
            Optional<Report> foundReport = reportRepository.findById(id);
            if (foundReport.isPresent()) {
                return foundReport.get();
            } else {
                throw new ReportDetailsNotFoundException("Report details not found!" + " id: " + id);
            }
        }else {
            throw new InvalidReportException("Report id not valid!" + " id: " + id);
        }
    }

    @Override
    public Report delete(int id) throws ReportDetailsNotFoundException, InvalidReportException {
        Report selectedReportForDelete = findById(id);
        if(selectedReportForDelete.equals(Report.class)) {
            reportRepository.delete(selectedReportForDelete);
            return selectedReportForDelete;
        } else {
            throw new ReportDetailsNotFoundException("Report details not found!" + " id: " + id);
        }
    }

    private boolean validate(Report report) {
        return true;
    }
}
