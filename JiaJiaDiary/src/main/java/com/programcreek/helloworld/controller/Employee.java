package com.programcreek.helloworld.controller;

import java.math.BigDecimal;
import java.util.Date;

public class Employee {
	private String name;
    private Date birthDate;
    private int payment;
    private double bonus;
    
    public Employee() {
	}
    
	
	public Employee(String string, Date parse, int i, double d) {
		this.name = string;
		this.birthDate = parse;
		this.payment = i;
		this.bonus = d;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}


	public int getPayment() {
		return payment;
	}


	public void setPayment(int payment) {
		this.payment = payment;
	}


	public double getBonus() {
		return bonus;
	}


	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	
}
