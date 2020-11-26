package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.demo.spring.model.User;
import com.demo.spring.repository.UserRepository;

@SpringBootApplication
public class DemoSecurityJpaLodaApplication  {

	public static void main(String[] args) {
		SpringApplication.run(DemoSecurityJpaLodaApplication.class, args);
	}

}
