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
import com.bridgelabz.employeepayroll.model.EmployeePayrollData;

@Service
public class EmployeePayrollService implements IEmployeePayRollService {

	public static final Logger logger = LoggerFactory.getLogger(EmployeePayrollService.class);
	AtomicLong id = new AtomicLong(0);
	@Override
	public List<EmployeePayrollData> getEmployeePayRollData() {
		List<EmployeePayrollData> employeePayrollDatas = new ArrayList<EmployeePayrollData>();
		EmployeePayrollData employeeData = null;
		employeePayrollDatas.add(new EmployeePayrollData(id.incrementAndGet(), new EmployeePayRollDTO("Harvey", 4000L)));
		return employeePayrollDatas;
	
	}

	@Override
	public EmployeePayrollData getEmployeePayRollDataById(long eId) {
		EmployeePayrollData employeeData = null;
		employeeData = new EmployeePayrollData(id.incrementAndGet(), new EmployeePayRollDTO("Harvey", 4000L));
		return employeeData;
	}

	@Override
	public EmployeePayrollData addEmployee(EmployeePayRollDTO dto) {
		EmployeePayrollData employeeData = null;
		employeeData = new EmployeePayrollData(id.incrementAndGet(), dto);
		return employeeData;
	}

	@Override
	public EmployeePayrollData updateEmployee(EmployeePayRollDTO dto) {
		EmployeePayrollData employeeData = null;
		employeeData = new EmployeePayrollData(id.incrementAndGet(), dto);
		return employeeData;
	}

	@Override
	public void deleteEmployee(long id) {
		logger.debug("Inside service delete");
	}

	

}
