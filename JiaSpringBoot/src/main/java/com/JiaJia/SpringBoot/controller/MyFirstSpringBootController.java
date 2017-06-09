package com.JiaJia.SpringBoot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyFirstSpringBootController {

	@RequestMapping("/index")
	public String index(){
		return "Hello";
	}
}
