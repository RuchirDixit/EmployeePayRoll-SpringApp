package com.bridgelabz.employeepayroll.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import lombok.Data;

public @Data class EmployeePayRollDTO {

	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}", message = "Employee Name Invalid")
	private String name;
	
	@Min(value = 1000, message = "Minimum salary has to be 1000")
	private Long salary;
	
	public EmployeePayRollDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public EmployeePayRollDTO(String name, Long salary) {
		this.name = name;
		this.salary = salary;
	}
}
