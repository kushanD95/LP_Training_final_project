package lk.sanuka.mobilegaragesystem.auth.authserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@EnableAuthorizationServer
@CrossOrigin(origins = "http://localhost:4200")
public class AuthServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthServerApplication.class, args);
	}

}
