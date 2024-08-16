package com.helloSpring.thirdServiceSecurity;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEncryptableProperties
public class HelloSpringApplication {



	public static void main(String[] args) {
		SpringApplication.run(HelloSpringApplication.class, args);
	}

}
