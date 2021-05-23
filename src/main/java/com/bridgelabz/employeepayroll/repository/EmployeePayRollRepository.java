package com.bridgelabz.employeepayroll.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bridgelabz.employeepayroll.model.EmployeePayrollData;

public interface EmployeePayRollRepository extends JpaRepository<EmployeePayrollData, Integer> {
	
	@Query(value = "select * from employee_payroll,employee_department where employee_id=id and department=:department",nativeQuery = true)
	public List<EmployeePayrollData> getEmployeeByDepartment(String department);
}
