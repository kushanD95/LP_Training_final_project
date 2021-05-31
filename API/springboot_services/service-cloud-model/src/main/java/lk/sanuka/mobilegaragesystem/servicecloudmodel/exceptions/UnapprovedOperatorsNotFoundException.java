package lk.sanuka.mobilegaragesystem.servicecloudmodel.exceptions;

import java.io.FileNotFoundException;

public class UnapprovedOperatorsNotFoundException extends FileNotFoundException {

    public UnapprovedOperatorsNotFoundException() {
        super();
    }

    public UnapprovedOperatorsNotFoundException(String s) {
        super(s);
    }
}
