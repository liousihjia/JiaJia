package com.programcreek.helloworld.controller;

public class TestItem {
	private String testId;
	private String testName;
	
	public TestItem(String testId, String testName) {
		this.testId = testId;
		this.testName = testName;
	}
	
	public TestItem(){
		
	}
	
	public String getTestId() {
		return testId;
	}
	public void setTestId(String testId) {
		this.testId = testId;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	
}
