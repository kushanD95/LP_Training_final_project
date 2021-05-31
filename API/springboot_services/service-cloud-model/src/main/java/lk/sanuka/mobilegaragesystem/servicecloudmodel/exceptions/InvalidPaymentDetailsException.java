package lk.sanuka.mobilegaragesystem.servicecloudmodel.exceptions;

import java.io.InvalidObjectException;

public class InvalidPaymentDetailsException extends InvalidObjectException {

    public InvalidPaymentDetailsException(String reason) {
        super(reason);
    }
}
