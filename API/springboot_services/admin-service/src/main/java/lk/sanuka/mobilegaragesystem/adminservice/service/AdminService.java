package lk.sanuka.mobilegaragesystem.adminservice.service;

import lk.sanuka.mobilegaragesystem.servicecloudmodel.model.operator.Operator;
import org.springframework.http.HttpStatus;

import java.util.Set;

public interface AdminService {
    public Set<Operator> getUnapprovedOperators();
}
