package com.cg.lab.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Component
public class SpringFoxConfig {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build()
				.apiInfo(myApiInfo());
	}
	
	//To display API Information - Inbuilt method
	private ApiInfo myApiInfo() {
		ApiInfo apiInfo = new ApiInfo(
				"Cart Microservice",
				"With Swagger Api",
				"1.0",
				"Free to Use",
				new Contact("Shivani Mane", "/api", "shivanimane20@gmail.com"),
				"API license",
				"/api",
				Collections.emptyList());
		return apiInfo;
	}

}
