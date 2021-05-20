package com.bridgelabz.employeepayroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class EmployeePayrollProjectApplication {

	public static void main(String[] args) {
		log.debug("Inside Employee Payroll Project main....");
		SpringApplication.run(EmployeePayrollProjectApplication.class, args);
	}

}
