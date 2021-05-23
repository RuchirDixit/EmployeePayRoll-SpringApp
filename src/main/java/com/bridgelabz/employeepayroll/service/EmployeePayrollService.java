package com.bridgelabz.employeepayroll.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bridgelabz.employeepayroll.dto.EmployeePayRollDTO;
import com.bridgelabz.employeepayroll.exceptions.EmployeePayRollException;
import com.bridgelabz.employeepayroll.model.EmployeePayrollData;
import com.bridgelabz.employeepayroll.repository.EmployeePayRollRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeePayrollService implements IEmployeePayRollService {
	
	@Autowired
	private EmployeePayRollRepository employeePayRollRepository;
	
	@Override
	public List<EmployeePayrollData> getEmployeePayRollData() {
		log.debug("Get all employees data");
		return employeePayRollRepository.findAll();
	
	}

	@Override
	public EmployeePayrollData getEmployeePayRollDataById(int eId) {
		log.debug("Get employee data for id: " + eId);
		return employeePayRollRepository.findById(eId)
				.orElseThrow(()-> 
							new EmployeePayRollException("Employee with ID:" + eId + " Not Found!"));
	}

	@Override
	public EmployeePayrollData addEmployee(EmployeePayRollDTO dto) {
		log.debug("Add Employee: "+ dto);
		EmployeePayrollData employeeData = null;
		employeeData = new EmployeePayrollData(dto);
		log.debug("Added employee:" + employeeData);
		return employeePayRollRepository.save(employeeData);
	}

	@Override
	public EmployeePayrollData updateEmployee(int empId,EmployeePayRollDTO dto) {
		log.debug("Update Employee: "+ dto);
		EmployeePayrollData employeeData = getEmployeePayRollDataById(empId);
		employeeData.updateEmployeePayRollData(dto);
		return employeePayRollRepository.save(employeeData);
	}

	@Override
	public void deleteEmployee(int id) {
		log.debug("Delete Employee with ID: "+ id);
		employeePayRollRepository.deleteById(id);
	}

	

}
