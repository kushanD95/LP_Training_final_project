package lk.sanuka.mobilegarage.garageservice.model;

import lk.sanuka.mobilegaragesystem.servicecloudmodel.model.driver.Driver;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.model.operator.Operator;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.model.task.Task;

public class FullResponseTask implements ResponseTask {
    Task task;
    Driver driver;
    Operator operator;
    public FullResponseTask(Task task, Driver driver, Operator operator) {
        this.task = task;
        this.operator = operator;
        this.driver = driver;
    }
}
