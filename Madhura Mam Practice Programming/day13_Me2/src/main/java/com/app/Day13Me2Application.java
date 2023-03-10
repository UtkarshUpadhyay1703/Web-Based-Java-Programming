package com.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class Day13Me2Application {

	public static void main(String[] args) {
		SpringApplication.run(Day13Me2Application.class, args);
	}


	
	//configure password encode bean
	@Bean

	public PasswordEncoder encoder() {
		System.out.println("in enc");
		return new BCryptPasswordEncoder();
	}

}
