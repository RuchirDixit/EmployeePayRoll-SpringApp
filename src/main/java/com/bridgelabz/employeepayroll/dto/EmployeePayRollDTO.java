package com.bridgelabz.employeepayroll.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

public @Data class EmployeePayRollDTO {

	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}", message = "Employee Name Invalid")
	private String name;
	
	@Min(value = 1000, message = "Minimum salary has to be 1000")
	private Long salary;
	
	@Pattern(regexp = "male|female", message = "Gender needs to be Male or Female")
	public String gender;
	
	@JsonFormat(pattern = "dd MMM yyyy")
	@NotNull(message = "Start Date cannot be empty.")
	@PastOrPresent(message = "Start Date should be past or present.")
	public LocalDate startDate;
	
	@NotBlank(message = "Note cannot be blank.")
	public String note;
	
	@NotBlank(message = "Profile picture cannot be blank.")
	public String profilePic;
	
	@NotNull(message = "Departments should not be empty.")
	public List<String> departments;
	
	public EmployeePayRollDTO(String name, Long salary) {
		this.name = name;
		this.salary = salary;
	}
}
