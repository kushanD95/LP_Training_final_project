package lk.sanuka.mobilegaragesystem.paymentservice.service;

import lk.sanuka.mobilegaragesystem.servicecloudmodel.consts.PaymentStatus;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.dto.payment.UpdatePaymentStatusDTO;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.exceptions.InvalidPaymentDetailsException;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.exceptions.PaymentDetailsNotFoundException;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.model.payment.Payment;

import java.util.Set;

public interface PaymentService {

    Payment save(Payment payment) throws InvalidPaymentDetailsException;
    Payment getPaymentById(int id) throws PaymentDetailsNotFoundException, InvalidPaymentDetailsException;
    Set<Payment> findPaymentByDriverId(int driverId) throws PaymentDetailsNotFoundException, InvalidPaymentDetailsException;
    Set<Payment> findPaymentByOperatorId(int operatorId) throws PaymentDetailsNotFoundException, InvalidPaymentDetailsException;
    Payment updatePaymentStatus(int id, UpdatePaymentStatusDTO updatePaymentStatusDTO) throws PaymentDetailsNotFoundException, InvalidPaymentDetailsException;
    Payment update(Payment payment) throws PaymentDetailsNotFoundException, InvalidPaymentDetailsException;

}
