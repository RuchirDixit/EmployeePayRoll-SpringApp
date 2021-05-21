package com.bridgelabz.employeepayroll.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.bridgelabz.employeepayroll.dto.EmployeePayRollDTO;

import lombok.Data;

@Entity
@Table(name = "employee_payroll")
public @Data class EmployeePayrollData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "employee_id")
	private long employeeID;
	
	@Column(name = "name")
	private String name;
	private long salary;
	private String gender;
	private LocalDate startDate;
	private String note;
	private String profilePic;
	
	@ElementCollection
	@CollectionTable(name = "employee_department" ,joinColumns = @JoinColumn(name = "id"))
	@Column(name = "department")
	private List<String> departments;

	
	public EmployeePayrollData(long id,EmployeePayRollDTO employeePayrollDto) {
		this.employeeID = id;
		this.updateEmployeePayRollData(employeePayrollDto);
	}


	private void updateEmployeePayRollData(EmployeePayRollDTO employeePayrollDto) {
		this.name = employeePayrollDto.getName();
		this.salary = employeePayrollDto.getSalary();
		this.gender = employeePayrollDto.getGender();
		this.startDate = employeePayrollDto.getStartDate();
		this.note = employeePayrollDto.getNote();
		this.profilePic = employeePayrollDto.getProfilePic();
		this.departments = employeePayrollDto.departments;
	}
}
