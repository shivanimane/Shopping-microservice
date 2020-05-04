package com.cg.lab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@SpringBootApplication
@EnableEurekaClient
@EnableJpaAuditing
@EnableSwagger2WebMvc
public class CustomerCartMicroservice {

	public static void main(String[] args) {
		SpringApplication.run(CustomerCartMicroservice.class, args);
	}

}
