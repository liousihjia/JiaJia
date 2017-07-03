package com.programcreek.helloworld.controller;
 
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
 
@Controller
public class testJson {
	String message = "hello";
 
	@RequestMapping("/openjson")
	public ModelAndView showMessage(
			@RequestParam(value = "result", required = false, defaultValue = "World") String result) {
		System.out.println("result === "+result);

		ObjectMapper mapper = new ObjectMapper();
		String prettyStaff1 = "";
		try {
		// Convert JSON string to Object
					String jsonInString = result;
					Staff staff1 = mapper.readValue(jsonInString, Staff.class);
					System.out.println(staff1);

					//Pretty print
					prettyStaff1 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(staff1);
					System.out.println(prettyStaff1);
		
//		System.out.println(obj.getName());
		
		}catch(Exception e){
			
		}
		
		ModelAndView mv = new ModelAndView("openjsonjsp");
		mv.addObject("message", message);
		mv.addObject("name", prettyStaff1);
		return mv;
	}
}