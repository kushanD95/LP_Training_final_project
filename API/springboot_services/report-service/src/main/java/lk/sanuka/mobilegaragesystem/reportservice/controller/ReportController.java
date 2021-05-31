package lk.sanuka.mobilegaragesystem.reportservice.controller;

import lk.sanuka.mobilegaragesystem.reportservice.service.EvidenceService;
import lk.sanuka.mobilegaragesystem.reportservice.service.ReportService;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.exceptions.InvalidReportException;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.exceptions.ReportDetailsNotFoundException;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.model.report.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/report")
public class ReportController {

    @Autowired
    ReportService reportService;

    @Autowired
    EvidenceService evidenceService;

    @PostMapping
    public ResponseEntity<Report> save(@RequestBody Report report) throws InvalidReportException {
        ResponseEntity<Report> responseEntity;
        responseEntity = new ResponseEntity(reportService.save(report), HttpStatus.OK);

        return responseEntity;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Report> findById(@PathVariable("id") int id) {
        ResponseEntity<Report> responseEntity;
        try {
            responseEntity = new ResponseEntity(reportService.findById(id),HttpStatus.OK);
        } catch (ReportDetailsNotFoundException e) {
            responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
            System.err.print(e.getMessage());
        } catch (InvalidReportException e) {
            responseEntity = new ResponseEntity(e.getMessage(),HttpStatus.SERVICE_UNAVAILABLE);
            System.err.print(e.getMessage());
        }

        return responseEntity;
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Report> delete(@PathVariable("id") int id) {
        ResponseEntity<Report> responseEntity;
        try {
            responseEntity = new ResponseEntity(reportService.delete(id),HttpStatus.OK);
            System.out.println("delete Report details id - "+ id);
        } catch (ReportDetailsNotFoundException | InvalidReportException e) {
            responseEntity = new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
            System.err.println(e.getMessage());
        }

        return responseEntity;
    }
}
