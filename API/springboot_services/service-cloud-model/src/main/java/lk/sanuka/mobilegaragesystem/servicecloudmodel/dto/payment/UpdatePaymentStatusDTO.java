package lk.sanuka.mobilegaragesystem.servicecloudmodel.dto.payment;

import lk.sanuka.mobilegaragesystem.servicecloudmodel.consts.PaymentStatus;

public class UpdatePaymentStatusDTO {

    public UpdatePaymentStatusDTO() {
    }

    public UpdatePaymentStatusDTO(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    private PaymentStatus paymentStatus;

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
