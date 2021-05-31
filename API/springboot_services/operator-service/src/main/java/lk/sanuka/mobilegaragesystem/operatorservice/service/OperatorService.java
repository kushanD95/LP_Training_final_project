package lk.sanuka.mobilegaragesystem.operatorservice.service;

import lk.sanuka.mobilegaragesystem.servicecloudmodel.exceptions.InvalidOperatorDetailsException;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.exceptions.OperatorDetailsNotFoundException;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.model.operator.Operator;

import java.util.Optional;
import java.util.Set;

public interface OperatorService {
    Operator save(Operator operator) throws InvalidOperatorDetailsException;

    Optional<Operator> findById(int id) throws InvalidOperatorDetailsException, OperatorDetailsNotFoundException;

    Operator update(Operator operator) throws InvalidOperatorDetailsException, OperatorDetailsNotFoundException;

    Optional<Operator> delete(int id) throws OperatorDetailsNotFoundException, InvalidOperatorDetailsException;

    Set<Operator> getUnapprovedOperators();
}
