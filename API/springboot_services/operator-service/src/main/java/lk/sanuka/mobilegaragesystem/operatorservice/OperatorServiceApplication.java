package lk.sanuka.mobilegaragesystem.operatorservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EntityScan(basePackages = {"lk.sanuka.mobilegaragesystem.servicecloudmodel.model.operator",
		"lk.sanuka.mobilegaragesystem.servicecloudmodel.model.location",
		"lk.sanuka.mobilegaragesystem.servicecloudmodel.exception"})
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableEurekaClient
public class OperatorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OperatorServiceApplication.class, args);
	}

}
