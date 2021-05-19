package com.bridgelabz.employeepayroll.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.employeepayroll.dto.EmployeePayRollDTO;
import com.bridgelabz.employeepayroll.dto.ResponseDTO;
import com.bridgelabz.employeepayroll.model.EmployeePayrollData;
import com.bridgelabz.employeepayroll.service.IEmployeePayRollService;

@RestController
@RequestMapping("/employee")
public class EmployeePayRollController {
	public static final Logger logger = LoggerFactory.getLogger(EmployeePayRollController.class);

	@Autowired
	IEmployeePayRollService employeePayService;
	
	@RequestMapping(value = {"","/"})
	public ResponseEntity<ResponseDTO> getEmployeePayRollData(){
		logger.debug("Inside get employee data");
		List<EmployeePayrollData> employeeData = employeePayService.getEmployeePayRollData();
		ResponseDTO responseDTO = new ResponseDTO("Get Employee Response",employeeData);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);	
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<ResponseDTO> getEmployeePayRollDataById(@PathVariable long id){
		logger.debug("Inside get employee data by id");
		EmployeePayrollData employeeData = employeePayService.getEmployeePayRollDataById(id);
		ResponseDTO responseDTO = new ResponseDTO("Get Employee Response",employeeData);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);	
	}
	
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addEmployee(@RequestBody EmployeePayRollDTO dto){
		logger.debug("Inside add employee data");
		EmployeePayrollData employeeData = employeePayService.addEmployee(dto);
		ResponseDTO responseDTO = new ResponseDTO("Created Employee",employeeData);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);	
	}
	
	@PostMapping("/update")
	public ResponseEntity<ResponseDTO> updateEmployee(@RequestBody EmployeePayRollDTO dto){
		logger.debug("Inside update employee data");
		EmployeePayrollData employeeData = employeePayService.updateEmployee(dto);
		ResponseDTO responseDTO = new ResponseDTO("Employee Updated",employeeData);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);	
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseDTO> deleteEmployee(@PathVariable long id){
		logger.debug("Inside delete employee data");
		employeePayService.deleteEmployee(id);
		ResponseDTO responseDTO = new ResponseDTO("Employee Deleted","Deleted id : " + id);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);	
	}
}
