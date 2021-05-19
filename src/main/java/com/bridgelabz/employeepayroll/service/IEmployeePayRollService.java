package com.bridgelabz.employeepayroll.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.bridgelabz.employeepayroll.dto.EmployeePayRollDTO;
import com.bridgelabz.employeepayroll.dto.ResponseDTO;
import com.bridgelabz.employeepayroll.model.EmployeePayrollData;

public interface IEmployeePayRollService {

	List<EmployeePayrollData> getEmployeePayRollData();
	
	EmployeePayrollData getEmployeePayRollDataById(long id);
	
	EmployeePayrollData addEmployee(EmployeePayRollDTO dto);
	
	EmployeePayrollData updateEmployee(EmployeePayRollDTO dto);
	
	void deleteEmployee(long id);
}
