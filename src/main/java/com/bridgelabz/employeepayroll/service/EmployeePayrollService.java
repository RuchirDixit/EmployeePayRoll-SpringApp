package com.bridgelabz.employeepayroll.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.slf4j.Logger;
import org.hibernate.boot.model.relational.Loggable;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bridgelabz.employeepayroll.controller.EmployeePayRollController;
import com.bridgelabz.employeepayroll.dto.EmployeePayRollDTO;
import com.bridgelabz.employeepayroll.dto.ResponseDTO;
import com.bridgelabz.employeepayroll.exceptions.EmployeePayRollException;
import com.bridgelabz.employeepayroll.model.EmployeePayrollData;

@Service
public class EmployeePayrollService implements IEmployeePayRollService {

	public static final Logger logger = LoggerFactory.getLogger(EmployeePayrollService.class);
	List<EmployeePayrollData> employeePayrollDatas = new ArrayList<EmployeePayrollData>();
	AtomicLong id = new AtomicLong(0);
	@Override
	public List<EmployeePayrollData> getEmployeePayRollData() {
		return employeePayrollDatas;
	
	}

	@Override
	public EmployeePayrollData getEmployeePayRollDataById(int eId) {
		return employeePayrollDatas.stream()
				.filter(empData -> empData.getEmployeeID() == eId)
				.findFirst()
				.orElseThrow(()-> 
							new EmployeePayRollException("Employee Not Found!"));
	}

	@Override
	public EmployeePayrollData addEmployee(EmployeePayRollDTO dto) {
		EmployeePayrollData employeeData = null;
		employeeData = new EmployeePayrollData(id.incrementAndGet(), dto);
		employeePayrollDatas.add(employeeData);
		return employeeData;
	}

	@Override
	public EmployeePayrollData updateEmployee(int empId,EmployeePayRollDTO dto) {
		EmployeePayrollData employeeData = getEmployeePayRollDataById(empId);
		employeeData.setName(dto.getName());
		employeeData.setSalary(dto.getSalary());
		employeePayrollDatas.set(empId-1, employeeData);
		return employeeData;
	}

	@Override
	public void deleteEmployee(long id) {
		employeePayrollDatas.remove(id);
	}

	

}
