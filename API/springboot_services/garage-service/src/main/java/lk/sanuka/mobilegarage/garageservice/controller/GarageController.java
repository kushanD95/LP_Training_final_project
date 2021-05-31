package lk.sanuka.mobilegarage.garageservice.controller;

import javassist.NotFoundException;
import lk.sanuka.mobilegarage.garageservice.model.ResponseTask;
import lk.sanuka.mobilegarage.garageservice.service.GarageService;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.dto.payment.UpdatePaymentStatusDTO;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.model.driver.Driver;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.model.operator.Operator;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.model.payment.Payment;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.model.report.Report;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.model.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/garage")
public class GarageController {

    @Autowired
    GarageService garageService;

    //driver's endpoints - START

    @PostMapping(value = "/driver")
    public ResponseEntity<Driver> saveDriver(@RequestBody Driver driver, @RequestHeader("Authorization") String token) {
        return garageService.saveDriver(driver,token);
    }

    @GetMapping(value = "/driver/{id}")
    public ResponseEntity<Driver> getDriverById(@PathVariable("id") int id, @RequestHeader("Authorization") String token) throws NotFoundException {
        try {
            return garageService.getDriverById(id, token);
        } catch (NotFoundException e) {
            throw e;
        }
    }

    @PutMapping(value = "/driver/{id}")
    public ResponseEntity<Driver> updateDriver(@RequestBody Driver driver, @RequestHeader("Authorization") String token,@PathVariable("id") int id) {
        return garageService.updateDriver(driver,token,id);
    }

    @DeleteMapping(value = "/driver/{id}")
    public ResponseEntity<Driver> deleteDriver(@PathVariable("id") int id, @RequestHeader("Authorization") String token) {
        return garageService.deleteDriver(id,token);
    }

    //operator's endpoints - START

    @PostMapping(value = "/operator")
    public ResponseEntity<Operator> saveOperator(@RequestBody Operator operator, @RequestHeader("Authorization") String token) {
        return garageService.saveOperator(operator,token);
    }

    @GetMapping(value = "/operator/{id}")
    public ResponseEntity<Operator> getOperatorById(@PathVariable("id") int id, @RequestHeader("Authorization") String token) {
        return garageService.getOperatorById(id,token);
    }

    @PutMapping(value = "/operator/{id}")
    public ResponseEntity<Operator> updateOperator(@RequestBody Operator operator, @RequestHeader("Authorization") String token) {
        return garageService.updateOperator(operator,token);
    }

    @DeleteMapping(value = "/operator/{id}")
    public ResponseEntity<Operator> deleteOperator(@PathVariable("id") int id, @RequestHeader("Authorization") String token) {
        return garageService.deleteOperator(id,token);
    }

    //payment endpoints - START

    @PostMapping(value = "/payment")
    public ResponseEntity<Payment> savePayment(@RequestBody Payment payment, @RequestHeader("Authorization") String token) {
        return garageService.savePayment(payment,token);
    }

    @GetMapping(value = "/payment/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable("id") int id, @RequestHeader("Authorization") String token) {
        return garageService.getPaymentById(id,token);
    }

    @GetMapping(value = "/payment/from_driver/{id}")
    public ResponseEntity<Payment> getPaymentByDriverId(@PathVariable("id") int id, @RequestHeader("Authorization") String token) {
        return garageService.getPaymentByDriverId(id,token);
    }

    @GetMapping(value = "/payment/from_operator/{id}")
    public ResponseEntity<Payment> getPaymentByOperatorId(@PathVariable("id") int id, @RequestHeader("Authorization") String token) {
        return garageService.getPaymentByOperatorId(id,token);
    }

    @PutMapping(value = "/payment/update_status/{id}")
    public ResponseEntity<Payment> updateStatusPayment(@RequestBody UpdatePaymentStatusDTO updatePaymentStatusDTO, @RequestHeader("Authorization") String token) {
        return garageService.updateStatusPayment(updatePaymentStatusDTO,token);
    }

    @PutMapping(value = "/payment/{id}")
    public ResponseEntity<Payment> updatePayment(@RequestBody Payment payment, @RequestHeader("Authorization") String token) {
        return garageService.updatePayment(payment,token);
    }


    //report endpoints - START

    @PostMapping(value = "/report")
    public ResponseEntity<Report> saveReport(@RequestBody Report report, @RequestHeader("Authorization") String token) {
        return garageService.saveReport(report,token);
    }

    @GetMapping(value = "/report/{id}")
    public ResponseEntity<Report> getReportById(@PathVariable("id") int id, @RequestHeader("Authorization") String token) {
        return garageService.getReportById(id,token);
    }

    @DeleteMapping(value = "/report/{id}")
    public ResponseEntity<Report> deleteReport(@PathVariable("id") int id, @RequestHeader("Authorization") String token) {
        return garageService.deleteReport(id,token);
    }

    //Task endpoints -START

    @PostMapping(value = "/task")
    public ResponseEntity<Task> saveTask(@RequestBody Task task) {
        return garageService.saveTask(task);
    }

    @GetMapping(value = "/task/{id}")
    public ResponseTask getTask(@PathVariable("id") String id, @RequestHeader("Authorization") String token) throws NotFoundException {
        return garageService.getTask(id,token);
    }

    @DeleteMapping(value = "/task/{id}")
    public ResponseEntity<Task> deleteTask(@PathVariable("id") int id) {
        return garageService.deleteTask(id);
    }


}
