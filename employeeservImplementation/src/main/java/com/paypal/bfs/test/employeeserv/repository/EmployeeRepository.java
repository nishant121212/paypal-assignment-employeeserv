package com.paypal.bfs.test.employeeserv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paypal.bfs.test.employeeserv.entity.Employee;

/**
 * 
 * Employee repository
 *
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
}
