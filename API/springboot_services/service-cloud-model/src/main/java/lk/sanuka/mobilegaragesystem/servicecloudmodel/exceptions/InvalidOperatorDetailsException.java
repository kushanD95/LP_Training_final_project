package lk.sanuka.mobilegaragesystem.servicecloudmodel.exceptions;

import java.io.InvalidObjectException;

public class InvalidOperatorDetailsException extends InvalidObjectException {
    public InvalidOperatorDetailsException(String reason) {
        super(reason);
    }
}
