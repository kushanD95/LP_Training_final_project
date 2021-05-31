package lk.sanuka.mobilegaragesystem.paymentservice.service.serviceimpl;

import lk.sanuka.mobilegaragesystem.paymentservice.repository.PaymentRepository;
import lk.sanuka.mobilegaragesystem.paymentservice.service.PaymentService;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.consts.PaymentStatus;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.dto.payment.UpdatePaymentStatusDTO;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.exceptions.InvalidPaymentDetailsException;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.exceptions.PaymentDetailsNotFoundException;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.model.payment.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.Set;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    @Override
    public Payment save(Payment payment) throws InvalidPaymentDetailsException {
        if(paymentValidate(payment)) {
            Payment payment1 = paymentRepository.save(payment);
            return payment1;
        } else {
            throw new InvalidPaymentDetailsException("Payment details are invalid!");
        }
    }

    @Override
    public Payment getPaymentById(int id) throws PaymentDetailsNotFoundException, InvalidPaymentDetailsException {
        if(id > 0) {
            Optional<Payment> payment = paymentRepository.findById(id);
            if(payment.isPresent()) {
                return payment.get();
            } else {
                throw new PaymentDetailsNotFoundException("Payment details are not found id - " + id);
            }
        } else {
            throw new InvalidPaymentDetailsException("Payment id is not valid id - " + id);
        }
    }

    @Override
    public Set<Payment> findPaymentByDriverId(int driverId) throws PaymentDetailsNotFoundException, InvalidPaymentDetailsException {
        if(driverId > 0) {
            Set<Payment> payments = paymentRepository.findPaymentByDriverId(driverId);
            if(!payments.isEmpty()) {
                return payments;
            } else {
                throw new PaymentDetailsNotFoundException("Payment details are not found driver id - " + driverId);
            }
        } else {
            throw new InvalidPaymentDetailsException("driver id is not valid id - " + driverId);
        }
    }

    @Override
    public Set<Payment> findPaymentByOperatorId(int operatorId) throws PaymentDetailsNotFoundException, InvalidPaymentDetailsException {
        if(operatorId > 0) {
            Set<Payment> payments = paymentRepository.findPaymentByOperatorId(operatorId);
            if(!payments.isEmpty()) {
                return payments;
            } else {
                throw new PaymentDetailsNotFoundException("Payment details are not found operator id - " + operatorId);
            }
        } else {
            throw new InvalidPaymentDetailsException("Operator id is not valid id - " + operatorId);
        }
    }

    @Override
    public Payment updatePaymentStatus(int id, UpdatePaymentStatusDTO updatePaymentStatusDTO) throws PaymentDetailsNotFoundException, InvalidPaymentDetailsException {
        Payment payment = this.getPaymentById(id);
        payment.setPaymentStatus(updatePaymentStatusDTO.getPaymentStatus());
        if(updatePaymentStatusDTO.getPaymentStatus() == PaymentStatus.PAYED) {
            payment.setPayed_date(new Date());
        }
        return save(payment);
    }

    @Override
    public Payment update(Payment payment) throws PaymentDetailsNotFoundException, InvalidPaymentDetailsException {
        getPaymentById(payment.getId());
        return save(payment);

    }

    private boolean paymentValidate(Payment payment) {
        return true;
    }
}
