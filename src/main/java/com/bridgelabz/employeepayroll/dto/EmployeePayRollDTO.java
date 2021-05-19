package com.bridgelabz.employeepayroll.dto;

public class EmployeePayRollDTO {

	private String name;
	private Long salary;
	
	public EmployeePayRollDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public EmployeePayRollDTO(String name, Long salary) {
		this.name = name;
		this.salary = salary;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSalary(Long salary) {
		this.salary = salary;
	}
	
	public String getName() {
		return name;
	}
	
	public Long getSalary() {
		return salary;
	}
}
