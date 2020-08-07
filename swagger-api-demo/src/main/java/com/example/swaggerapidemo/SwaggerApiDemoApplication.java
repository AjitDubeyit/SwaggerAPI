package com.example.swaggerapidemo;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
public class SwaggerApiDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwaggerApiDemoApplication.class, args);
	}

	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/api/*"))
				.apis(RequestHandlerSelectors.basePackage("com.example.swaggerapidemo"))
				.build()
				.apiInfo(apiDetails());
	}
 
	private ApiInfo apiDetails() {
		return new ApiInfo("Address book API", "Sample API by Ajit Dubey", "1.0", 
				"http://localhost:8080/swagger-ui.html",
				new Contact("Ajit Dubey", "http://localhost:8080/swagger-ui.html", "ajitdubey.it@gmail.com"),
				"API License", "www.ajitdubey.com",Collections.emptyList());
	}
}
