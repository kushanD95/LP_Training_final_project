package lk.sanuka.mobilegaragesystem.servicecloudmodel.exceptions;

import java.io.InvalidObjectException;

public class InvalidReportException extends InvalidObjectException {

    public InvalidReportException(String reason) {
        super(reason);
    }
}
