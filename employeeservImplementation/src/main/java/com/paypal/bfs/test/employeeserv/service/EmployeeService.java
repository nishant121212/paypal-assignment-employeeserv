package com.paypal.bfs.test.employeeserv.service;

import com.paypal.bfs.test.employeeserv.api.model.Employee;

/**
 * Employee service interface
 *
 */
public interface EmployeeService {
	
	/**
	 * get employee by its id
	 * 
	 * @param id employee id
	 * @return {@link Employee}
	 */
    Employee employeeGetById(String id);

    /**
     * creates a new employee
     * 
     * @param employee {@link Employee}
     * @return Integer employee id
     */
    Integer createEmployee(Employee employee);
	
}
