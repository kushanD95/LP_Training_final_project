package lk.sanuka.mobilegaragesystem.servicecloudmodel.exceptions;

import java.io.FileNotFoundException;

public class PaymentDetailsNotFoundException extends FileNotFoundException {

    public PaymentDetailsNotFoundException() {
        super();
    }

    public PaymentDetailsNotFoundException(String s) {
        super(s);
    }
}
