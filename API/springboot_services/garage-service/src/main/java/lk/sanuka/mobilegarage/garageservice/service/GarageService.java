package lk.sanuka.mobilegarage.garageservice.service;

import javassist.NotFoundException;
import lk.sanuka.mobilegarage.garageservice.model.ResponseTask;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.dto.payment.UpdatePaymentStatusDTO;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.model.driver.Driver;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.model.operator.Operator;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.model.payment.Payment;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.model.report.Report;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.model.task.Task;
import org.springframework.http.ResponseEntity;

public interface GarageService {
    ResponseEntity<Driver> saveDriver(Driver driver,String token);

    ResponseEntity<Driver> getDriverById(int id, String token) throws NotFoundException;

    ResponseEntity<Driver> updateDriver(Driver driver,String token,int id);

    ResponseEntity<Driver> deleteDriver(int id,String token);

    ResponseEntity<Operator> saveOperator(Operator operator, String token);

    ResponseEntity<Operator> getOperatorById(int id, String token);

    ResponseEntity<Operator> deleteOperator(int id, String token);

    ResponseEntity<Operator> updateOperator(Operator operator, String token);

    ResponseEntity<Payment> savePayment(Payment payment, String token);

    ResponseEntity<Payment> getPaymentById(int id, String token);

    ResponseEntity<Payment> getPaymentByDriverId(int id, String token);

    ResponseEntity<Payment> getPaymentByOperatorId(int id, String token);

    ResponseEntity<Payment> updateStatusPayment(UpdatePaymentStatusDTO updatePaymentStatusDTO, String token);

    ResponseEntity<Payment> updatePayment(Payment payment, String token);

    ResponseEntity<Report> saveReport(Report report, String token);

    ResponseEntity<Report> getReportById(int id, String token);

    ResponseEntity<Report> deleteReport(int id, String token);

    ResponseEntity<Task> saveTask(Task task);

    Task getTaskById(String id);

    Task getTaskByDriverId(int id);

    Task getTaskByOperatorId(int id);

    ResponseEntity<Task> deleteTask(int id);

    ResponseTask getTask(String id, String token) throws NotFoundException;
}
