package lk.sanuka.mobilegaragesystem.servicecloudmodel.model.payment;

import lk.sanuka.mobilegaragesystem.servicecloudmodel.consts.PaymentStatus;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.model.driver.Driver;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int driver_id;
    private int operator_id;
    private BigDecimal amount;
    private Date created_date;
    private Date payed_date;
    private PaymentStatus paymentStatus;

    public Payment() {
    }

    public Payment(Payment payment) {
        this.id = payment.getId();
        this.driver_id = payment.getDriver_id();
        this.operator_id = payment.getOperator_id();
        this.amount = payment.getAmount();
        this.created_date = payment.getCreated_date();
        this.payed_date = payment.getPayed_date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(int driver_id) {
        this.driver_id = driver_id;
    }

    public int getOperator_id() {
        return operator_id;
    }

    public void setOperator_id(int operator_id) {
        this.operator_id = operator_id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public Date getPayed_date() {
        return payed_date;
    }

    public void setPayed_date(Date payed_date) {
        this.payed_date = payed_date;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
