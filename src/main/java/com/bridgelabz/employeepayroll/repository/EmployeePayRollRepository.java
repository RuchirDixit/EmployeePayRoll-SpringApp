package com.bridgelabz.employeepayroll.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bridgelabz.employeepayroll.model.EmployeePayrollData;

public interface EmployeePayRollRepository extends JpaRepository<EmployeePayrollData, Integer> {
}
