package com.bridgelabz.employeepayroll.model;

import com.bridgelabz.employeepayroll.dto.EmployeePayRollDTO;

public class EmployeePayrollData {

	private long employeeID;
	private String name;
	private long salary;

	
	public EmployeePayrollData(long id,EmployeePayRollDTO employeePayrollDto) {
		this.employeeID = id;
		this.name = employeePayrollDto.getName();
		this.salary = employeePayrollDto.getSalary();
	}
	
	public long getEmployeeID() {
		return employeeID;
	}
	
	public void setEmployeeID(long employeeID) {
		this.employeeID = employeeID;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSalary(long salary) {
		this.salary = salary;
	}
	
	public String getName() {
		return name;
	}
	
	public long getSalary() {
		return salary;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Name - " + this.name + " : Salary - " + this.salary;
	}
}
