package lk.sanuka.mobilegaragesystem.servicecloudmodel.exceptions;

import java.io.InvalidObjectException;

public class InvalidDriverDetailsException extends InvalidObjectException {

    public InvalidDriverDetailsException(String reason) {
        super(reason);
    }
}
