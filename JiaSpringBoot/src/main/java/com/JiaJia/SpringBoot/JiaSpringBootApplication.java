package com.JiaJia.SpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@SpringBootApplication
public class JiaSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(JiaSpringBootApplication.class, args);
	}
	
	@RequestMapping("/index2")
	public String index2(){
		return "Hello";
	}
}
