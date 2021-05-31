package lk.sanuka.mobilegarage.garageservice.service.serviceimpl;

import javassist.NotFoundException;
import lk.sanuka.mobilegarage.garageservice.model.FullResponseTask;
import lk.sanuka.mobilegarage.garageservice.model.ResponseTask;
import lk.sanuka.mobilegarage.garageservice.service.GarageService;
import lk.sanuka.mobilegarage.garageservice.service.TaskService;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.dto.payment.UpdatePaymentStatusDTO;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.model.driver.Driver;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.model.operator.Operator;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.model.payment.Payment;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.model.report.Report;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.model.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
@EnableEurekaClient
public class GarageServiceImpl implements GarageService {
    String ifHasJsonBody = "application/json";

    @LoadBalanced
    @Bean
    private RestTemplate getRestTemplate(RestTemplateBuilder builder){

        return builder.build();
    }

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    TaskService taskService;

    @Override
    public ResponseEntity<Driver> saveDriver(Driver driver,String token) {
        return restTemplate.exchange("http://driver/driver", HttpMethod.POST,setHeaders(token,ifHasJsonBody,driver),Driver.class);
    }

    @Override
    public ResponseEntity<Driver> getDriverById(int id, String token) throws NotFoundException {
        return restTemplate.exchange("http://driver/driver/" + id, HttpMethod.GET, setHeaders(token), Driver.class);
    }

    @Override
    public ResponseEntity<Driver> updateDriver(Driver driver,String token,int id) {

        return restTemplate.exchange("http://driver/driver/"+id, HttpMethod.PUT,setHeaders(token,ifHasJsonBody,driver),Driver.class);
    }

    @Override
    public ResponseEntity<Driver> deleteDriver(int id,String token) {

        return restTemplate.exchange("http://driver/driver/"+id, HttpMethod.DELETE,setHeaders(token),Driver.class);
    }

    @Override
    public ResponseEntity<Operator> saveOperator(Operator operator, String token) {
        return restTemplate.postForEntity("http://operator/operator/",Operator.class,Operator.class);
    }

    @Override
    public ResponseEntity<Operator> getOperatorById(int id, String token) {
        return restTemplate.getForObject("http://operator/operator/"+id,ResponseEntity.class);
    }

    @Override
    public ResponseEntity<Operator> deleteOperator(int id, String token) {
        return restTemplate.exchange("http://operator/operator/"+id, HttpMethod.DELETE,setHeaders(token),Operator.class);
    }

    @Override
    public ResponseEntity<Operator> updateOperator(Operator operator, String token) {
        return null;
    }

    @Override
    public ResponseEntity<Payment> savePayment(Payment payment, String token) {
        return restTemplate.postForEntity("http://payment/payment/",Payment.class,Payment.class);
    }

    @Override
    public ResponseEntity<Payment> getPaymentById(int id, String token) {
        return restTemplate.getForObject("http://payment/payment/"+id,ResponseEntity.class);
    }

    @Override
    public ResponseEntity<Payment> getPaymentByDriverId(int id, String token) {
        return restTemplate.getForObject("http://payment/payment/driver/"+id,ResponseEntity.class);
    }

    @Override
    public ResponseEntity<Payment> getPaymentByOperatorId(int id, String token) {
        return restTemplate.getForObject("http://payment/payment/operator/"+id,ResponseEntity.class);
    }

    @Override
    public ResponseEntity<Payment> updateStatusPayment(UpdatePaymentStatusDTO updatePaymentStatusDTO, String token) {
        return null;
    }

    @Override
    public ResponseEntity<Payment> updatePayment(Payment payment, String token) {
        return null;
    }

    @Override
    public ResponseEntity<Report> saveReport(Report report, String token) {
        return restTemplate.postForEntity("http://report/report/",Report.class,Report.class);
    }

    @Override
    public ResponseEntity<Report> getReportById(int id, String token) {
        return restTemplate.getForObject("http://report/report/"+id,ResponseEntity.class);
    }

    @Override
    public ResponseEntity<Report> deleteReport(int id, String token) {
        return null;
    }

    @Override
    public ResponseEntity<Task> saveTask(Task task) {
        return this.taskService.saveTask(task);
    }

    @Override
    public Task getTaskById(String id) {

        return this.taskService.getTaskById(id);
    }

    @Override
    public Task getTaskByDriverId(int id) {

        return this.taskService.getTaskByDriverId(id);
    }

    @Override
    public Task getTaskByOperatorId(int id) {

        return this.taskService.getTaskByOperatorId(id);
    }

    @Override
    public ResponseEntity<Task> deleteTask(int id) {
        this.taskService.deleteTask(id);
        return null;
    }

    @Override
    public ResponseTask getTask(String id, String token) throws NotFoundException {

        Task task = this.getTaskById(id);
        Driver driver;
        Operator operator;

        if(task != null) {
            driver = this.getDriverById(task.getDriver_id(),token).getBody();
            if(task.getOperator_id() > 0) {
                operator = this.getOperatorById(task.getOperator_id(),token).getBody();
            } else {
                operator = new Operator();
            }
            return new FullResponseTask(task,driver,operator);
        } else {
            return null;
        }
    }

    private HttpEntity<String> setHeaders(String token, String type, Object body) {
        HttpHeaders headers = new HttpHeaders();

        headers.set("Authorization", token);

        if(type == ifHasJsonBody) {
            headers.set("Content-Type", type);
        }

        HttpEntity entity = new HttpEntity (body,headers);
        return entity;
    }

    private HttpEntity<String> setHeaders(String token) {
        HttpHeaders headers = new HttpHeaders();

        headers.set("Authorization", token);

        HttpEntity<String> entity = new HttpEntity <> (headers);
        return entity;
    }
}
