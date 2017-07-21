package com.programcreek.helloworld.controller;
 
import java.text.ParseException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
 
@Controller
public class HelloWorldController {
	String message = "Welcome to Spring MVC!";
 
	@RequestMapping("/hello")
	public ModelAndView showMessage(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		System.out.println("in controller");
 
		ModelAndView mv = new ModelAndView("helloworld");
		mv.addObject("message", message);
		mv.addObject("name", name);
		
		
		List<Employee> employees = null;
		try {
			employees = ObjectCollectionDemo.generateSampleEmployeeData();
			ObjectMapper mapper = new ObjectMapper();
			try {
				String objectJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(employees);
				mv.addObject("message", objectJson);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return mv;
	}
}