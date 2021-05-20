package com.bridgelabz.employeepayroll.dto;

import lombok.Data;

public @Data class EmployeePayRollDTO {

	private String name;
	private Long salary;
	
	public EmployeePayRollDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public EmployeePayRollDTO(String name, Long salary) {
		this.name = name;
		this.salary = salary;
	}
}
