package lk.sanuka.mobilegaragesystem.operatorservice.service.serviceimpl;

import lk.sanuka.mobilegaragesystem.operatorservice.repository.OperatorRepository;
import lk.sanuka.mobilegaragesystem.operatorservice.service.OperatorService;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.exceptions.InvalidOperatorDetailsException;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.exceptions.OperatorDetailsNotFoundException;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.model.operator.Operator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class OperatorServiceImpl implements OperatorService {

    @Autowired
    OperatorRepository operatorRepository;

    @Override
    public Operator save(Operator operator) throws InvalidOperatorDetailsException {
        if(!operatorValidate(operator)) {
            Operator operator1 = operatorRepository.save(operator);
            return operator1;
        } else {
            throw new InvalidOperatorDetailsException("Operator Details are Invalid");
        }
    }

    @Override
    public Optional<Operator> findById(int id) throws InvalidOperatorDetailsException, OperatorDetailsNotFoundException {
        if (id > 0 ) {
            Optional<Operator> foundOperator = operatorRepository.findById(id);
            if (foundOperator.isPresent()) {
                return foundOperator;
            } else {
                throw new OperatorDetailsNotFoundException("Operator details not found!" + " id: " + id);
            }
        }else {
            throw new InvalidOperatorDetailsException("Operator id not valid!" + " id: " + id);
        }
    }

    @Override
    public Operator update(Operator operator) throws InvalidOperatorDetailsException, OperatorDetailsNotFoundException {
        findById(operator.getId());
        return save(operator);
    }

    @Override
    public Optional<Operator> delete(int id) throws OperatorDetailsNotFoundException, InvalidOperatorDetailsException {
        Optional<Operator> selectedOperatorForDelete = findById(id);
        if(selectedOperatorForDelete.isPresent()) {
            operatorRepository.delete(selectedOperatorForDelete.get());
            return selectedOperatorForDelete;
        } else {
            throw new OperatorDetailsNotFoundException("Operator details not found!" + " id: " + id);
        }
    }

    @Override
    public Set<Operator> getUnapprovedOperators() {
        return operatorRepository.getUnapprovedOperators();
    }

    private boolean operatorValidate(Operator operator) {
//        boolean isInvalid =true;
//        Pattern pattern = Pattern.compile(this.drivingLicenceExpression);
//        if(pattern.matcher(Operator.getLicenceNo()))
        return false;
    }
}
