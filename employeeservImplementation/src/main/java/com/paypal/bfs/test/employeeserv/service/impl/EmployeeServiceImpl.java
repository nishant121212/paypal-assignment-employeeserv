package com.paypal.bfs.test.employeeserv.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.exception.EmployeeNotFoundException;
import com.paypal.bfs.test.employeeserv.mapper.EmployeeMapper;
import com.paypal.bfs.test.employeeserv.repository.EmployeeRepository;
import com.paypal.bfs.test.employeeserv.service.EmployeeService;

/**
 * Employee service implementation
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee employeeGetById(String id) {
		com.paypal.bfs.test.employeeserv.entity.Employee employee = employeeRepository.findById(Integer.valueOf(id))
    			.orElseThrow(EmployeeNotFoundException::new);
    	return EmployeeMapper.mapEntityToModel(employee);
	}

	@Override
	public Integer createEmployee(Employee employee) {
		com.paypal.bfs.test.employeeserv.entity.Employee employeeEntity = EmployeeMapper.mapModelToEntity(employee);
		return employeeRepository.save(employeeEntity).getId();
	}

}
