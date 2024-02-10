package com.serviceassurance.payall;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @ComponentScan({"*"})
public class PayallApplication {

	@Autowired
	public static void main(String[] args) {
		SpringApplication.run(PayallApplication.class, args);
	}

	

}
