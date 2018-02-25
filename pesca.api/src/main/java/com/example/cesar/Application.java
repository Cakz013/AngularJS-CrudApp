package com.example.cesar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication(scanBasePackages={
						"com.example.cesar.web.controllers",
						"com.example.cesar.core.services",
						"com.example.cesar.core.dao"}) 
//Es lo mismo que anotar con @Configuration @EnableAutoConfiguration @ComponentScan
//@EnableJpaRepositories
//@EnableCaching
@Import(JpaConfiguration.class)
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
