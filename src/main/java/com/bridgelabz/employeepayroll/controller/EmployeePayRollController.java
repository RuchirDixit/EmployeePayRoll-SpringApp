package com.bridgelabz.employeepayroll.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.employeepayroll.dto.EmployeePayRollDTO;
import com.bridgelabz.employeepayroll.dto.ResponseDTO;
import com.bridgelabz.employeepayroll.model.EmployeePayrollData;

@RestController
@RequestMapping("/employee")
public class EmployeePayRollController {
	public static final Logger logger = LoggerFactory.getLogger(EmployeePayRollController.class);
	AtomicLong id = new AtomicLong(0);

	@RequestMapping(value = {"","/"})
	public ResponseEntity<ResponseDTO> getEmployeePayRollData(){
		logger.debug("Inside get employee data");
		EmployeePayrollData employeeData = null;
		employeeData = new EmployeePayrollData(id.incrementAndGet(), new EmployeePayRollDTO("Harvey", 4000L));
		ResponseDTO responseDTO = new ResponseDTO("Get Employee Response",employeeData);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);	
	}
	
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addEmployee(@RequestBody EmployeePayRollDTO dto){
		logger.debug("Inside add employee data");
		EmployeePayrollData employeeData = null;
		employeeData = new EmployeePayrollData(id.incrementAndGet(), dto);
		ResponseDTO responseDTO = new ResponseDTO("Created Employee",employeeData);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);	
	}
	
	@PostMapping("/update")
	public ResponseEntity<ResponseDTO> updateEmployee(@RequestBody EmployeePayRollDTO dto){
		logger.debug("Inside update employee data");
		EmployeePayrollData employeeData = null;
		employeeData = new EmployeePayrollData(id.incrementAndGet(), dto);
		ResponseDTO responseDTO = new ResponseDTO("Employee Updated",employeeData);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);	
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseDTO> deleteEmployee(@PathVariable long id){
		logger.debug("Inside delete employee data");
		ResponseDTO responseDTO = new ResponseDTO("Employee Deleted","Deleted id : " + id);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);	
	}
}
