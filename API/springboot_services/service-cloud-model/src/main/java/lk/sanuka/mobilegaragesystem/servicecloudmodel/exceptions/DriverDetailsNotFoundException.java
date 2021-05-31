package lk.sanuka.mobilegaragesystem.servicecloudmodel.exceptions;

import java.io.FileNotFoundException;

public class DriverDetailsNotFoundException extends FileNotFoundException {
    public DriverDetailsNotFoundException() {
        super();
    }

    public DriverDetailsNotFoundException(String s) {
        super(s);
    }
}
