package lk.sanuka.mobilegaragesystem.adminservice.service.adminserviceimpl;

import lk.sanuka.mobilegaragesystem.adminservice.service.AdminService;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.model.operator.Operator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AdminServiceImpl implements AdminService {

    @Bean
    RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
    
    @Autowired
    RestTemplate restTemplate;
    
    @Override
    public Set<Operator> getUnapprovedOperators() {
        Set<Operator> unapprovedOperators = new HashSet(Arrays.asList(restTemplate.getForObject("http://localhost:8083/operator/unapprovedOperators",Operator[].class)));
        return unapprovedOperators;
    }
}
