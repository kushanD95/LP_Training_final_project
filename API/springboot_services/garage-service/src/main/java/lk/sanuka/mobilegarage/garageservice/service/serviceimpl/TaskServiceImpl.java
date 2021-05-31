package lk.sanuka.mobilegarage.garageservice.service.serviceimpl;

import javassist.NotFoundException;
import lk.sanuka.mobilegarage.garageservice.model.FullResponseTask;
import lk.sanuka.mobilegarage.garageservice.model.ResponseTask;
import lk.sanuka.mobilegarage.garageservice.service.TaskService;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.model.driver.Driver;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.model.operator.Operator;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.model.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TaskServiceImpl implements TaskService {

    @Bean
    private RestTemplate getRestTemplateTask(RestTemplateBuilder builder2){

        return builder2.build();
    }


    private RestTemplate restTemplate2 = new RestTemplate();

    @Override
    public ResponseEntity<Task> saveTask(Task task) {
        return restTemplate2.postForEntity("http://localhost:8085/task",task,Task.class);
    }

    @Override
    public Task getTaskById(String id) {

        return restTemplate2.getForObject("http://localhost:8085/task/"+id,Task.class);
    }

    @Override
    public Task getTaskByDriverId(int id) {

        return restTemplate2.getForObject("http://localhost:8085/task/driver/"+id,Task.class);
    }

    @Override
    public Task getTaskByOperatorId(int id) {

        return restTemplate2.getForObject("http://localhost:8085/task/operator/"+id,Task.class);
    }

    @Override
    public ResponseEntity<Task> deleteTask(int id) {
        restTemplate2.delete("http://localhost:8085/task/"+id);
        return null;
    }

}
