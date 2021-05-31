package lk.sanuka.mobilegarage.garageservice.service;

import lk.sanuka.mobilegaragesystem.servicecloudmodel.model.task.Task;
import org.springframework.http.ResponseEntity;

public interface TaskService {
    ResponseEntity<Task> saveTask(Task task);

    Task getTaskById(String id);

    Task getTaskByDriverId(int id);

    Task getTaskByOperatorId(int id);

    ResponseEntity<Task> deleteTask(int id);
}
