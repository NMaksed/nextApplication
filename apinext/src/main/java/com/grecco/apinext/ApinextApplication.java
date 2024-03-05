package com.grecco.apinext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.grecco.apinext.model"})
public class ApinextApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApinextApplication.class, args);
	}

}
