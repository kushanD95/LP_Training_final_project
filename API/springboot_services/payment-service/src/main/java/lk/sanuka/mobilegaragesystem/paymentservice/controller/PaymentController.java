package lk.sanuka.mobilegaragesystem.paymentservice.controller;

import lk.sanuka.mobilegaragesystem.paymentservice.service.PaymentService;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.consts.PaymentStatus;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.dto.payment.UpdatePaymentStatusDTO;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.exceptions.InvalidPaymentDetailsException;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.exceptions.PaymentDetailsNotFoundException;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.model.payment.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping
    public ResponseEntity<Payment> save(@RequestBody Payment payment) {
        ResponseEntity<Payment> responseEntity;

        try {
            responseEntity = new ResponseEntity(paymentService.save(payment), HttpStatus.OK);
        } catch (InvalidPaymentDetailsException e) {
            responseEntity = new ResponseEntity(e.getMessage(),HttpStatus.SERVICE_UNAVAILABLE);
            System.err.print(e.getMessage());
        }

        return responseEntity;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Payment> findById(@PathVariable("id") int id){
        ResponseEntity<Payment> responseEntity;

        try {
            responseEntity = new ResponseEntity(paymentService.getPaymentById(id),HttpStatus.OK);
        } catch (PaymentDetailsNotFoundException e) {
            responseEntity = new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        } catch (InvalidPaymentDetailsException e) {
            responseEntity = new ResponseEntity(e.getMessage(),HttpStatus.SERVICE_UNAVAILABLE);
        }

        return responseEntity;
    }

    @GetMapping(value = "/driver/{id}")
    public ResponseEntity<Payment> findByDriverId(@PathVariable("id") int id){
        ResponseEntity<Payment> responseEntity;

        try {
            responseEntity = new ResponseEntity(paymentService.findPaymentByDriverId(id),HttpStatus.OK);
        } catch (PaymentDetailsNotFoundException e) {
            responseEntity = new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        } catch (InvalidPaymentDetailsException e) {
            responseEntity = new ResponseEntity(e.getMessage(),HttpStatus.SERVICE_UNAVAILABLE);
        }

        return responseEntity;
    }

    @GetMapping(value = "/operator/{id}")
    public ResponseEntity<Payment> findByOperatorId(@PathVariable("id") int id){
        ResponseEntity<Payment> responseEntity;

        try {
            responseEntity = new ResponseEntity(paymentService.findPaymentByOperatorId(id),HttpStatus.OK);
        } catch (PaymentDetailsNotFoundException e) {
            responseEntity = new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        } catch (InvalidPaymentDetailsException e) {
            responseEntity = new ResponseEntity(e.getMessage(),HttpStatus.SERVICE_UNAVAILABLE);
        }

        return responseEntity;
    }

    @PutMapping
    public ResponseEntity<Payment> update(@RequestBody Payment payment){
        ResponseEntity<Payment> responseEntity;

        try {
            responseEntity = new ResponseEntity(paymentService.update(payment),HttpStatus.OK);
        } catch (PaymentDetailsNotFoundException e) {
            responseEntity = new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        } catch (InvalidPaymentDetailsException e) {
            responseEntity = new ResponseEntity(e.getMessage(),HttpStatus.SERVICE_UNAVAILABLE);
        }

        return responseEntity;
    }

    @PutMapping(value = "/status_update/{payment_id}")
    public ResponseEntity<Payment> statusUpdate(@RequestBody UpdatePaymentStatusDTO updatePaymentStatusDTO, @PathVariable("payment_id") int id) {
        ResponseEntity<Payment> responseEntity;

        try {
            responseEntity = new ResponseEntity(paymentService.updatePaymentStatus(id, updatePaymentStatusDTO), HttpStatus.OK);
        } catch (PaymentDetailsNotFoundException e) {
            responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (InvalidPaymentDetailsException e) {
            responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
        }

        return responseEntity;
    }
}
