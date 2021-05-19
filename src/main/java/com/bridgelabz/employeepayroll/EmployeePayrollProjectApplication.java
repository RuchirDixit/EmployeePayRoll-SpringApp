package com.bridgelabz.employeepayroll;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeePayrollProjectApplication {

	public static final Logger logger = LoggerFactory.getLogger(EmployeePayrollProjectApplication.class);
	public static void main(String[] args) {
		logger.debug("Inside Employee Payroll Project main....");
		SpringApplication.run(EmployeePayrollProjectApplication.class, args);
	}

}
