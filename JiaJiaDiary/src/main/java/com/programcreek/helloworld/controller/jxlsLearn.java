package com.programcreek.helloworld.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.List;

import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;

public class jxlsLearn {
	public static void main(String args[]){
		List<Employee> employees = null;
		try {
			employees = ObjectCollectionDemo.generateSampleEmployeeData();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try(InputStream is = ObjectCollectionDemo.class.getResourceAsStream("object_collection_template.xls")) {
	        try (OutputStream os = new FileOutputStream("target/object_collection_output.xls")) {
	            Context context = new Context();
	            context.putVar("employees", employees);
//	            JxlsHelper.getInstance().processTemplate(is, os, context);
	            JxlsHelper.getInstance().processTemplateAtCell(is, os, context, "Result!A1");
	        } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    } catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
}
