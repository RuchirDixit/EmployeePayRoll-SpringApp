package com.bridgelabz.employeepayroll.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bridgelabz.employeepayroll.dto.EmployeePayRollDTO;
import com.bridgelabz.employeepayroll.dto.ResponseDTO;
import com.bridgelabz.employeepayroll.model.EmployeePayrollData;
import com.bridgelabz.employeepayroll.service.IEmployeePayRollService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/employee")
@Slf4j
public class EmployeePayRollController {

	@Autowired
	IEmployeePayRollService employeePayService;
	
	@RequestMapping(value = {"","/"})
	public ResponseEntity<ResponseDTO> getEmployeePayRollData(){
		log.debug("Inside get employee data");
		List<EmployeePayrollData> employeeData = employeePayService.getEmployeePayRollData();
		ResponseDTO responseDTO = new ResponseDTO("Get Employee Response",employeeData);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);	
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<ResponseDTO> getEmployeePayRollDataById(@PathVariable int id){
		log.debug("Inside get employee data by id");
		EmployeePayrollData employeeData = employeePayService.getEmployeePayRollDataById(id);
		ResponseDTO responseDTO = new ResponseDTO("Get Employee Response",employeeData);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);	
	}
	
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addEmployee(@RequestBody EmployeePayRollDTO dto){
		log.debug("Inside add employee data");
		EmployeePayrollData employeeData = employeePayService.addEmployee(dto);
		ResponseDTO responseDTO = new ResponseDTO("Created Employee",employeeData);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);	
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<ResponseDTO> updateEmployee(@PathVariable int id,@RequestBody EmployeePayRollDTO dto){
		log.debug("Inside update employee data");
		EmployeePayrollData employeeData = employeePayService.updateEmployee(id,dto);
		ResponseDTO responseDTO = new ResponseDTO("Employee Updated",employeeData);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);	
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseDTO> deleteEmployee(@PathVariable long id){
		log.debug("Inside delete employee data");
		employeePayService.deleteEmployee(id);
		ResponseDTO responseDTO = new ResponseDTO("Employee Deleted","Deleted id : " + id);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);	
	}
}
