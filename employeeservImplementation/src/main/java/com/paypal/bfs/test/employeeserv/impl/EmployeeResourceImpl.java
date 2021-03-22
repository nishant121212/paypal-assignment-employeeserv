package com.paypal.bfs.test.employeeserv.impl;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.paypal.bfs.test.employeeserv.api.EmployeeResource;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.exception.EmployeeServiceException;
import com.paypal.bfs.test.employeeserv.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

/**
 * Implementation class for employee resource.
 */
@RestController
@Slf4j
public class EmployeeResourceImpl implements EmployeeResource {
	private static final String EMPLOYEE_CONTEXT_PATH = "/v1/bfs/employees/";

	@Autowired
	private EmployeeService employeeService;
	
        @Override
        public ResponseEntity<Employee> employeeGetById(String id) {
            log.info("fetching employee details for: {}", id);
            return new ResponseEntity<>(employeeService.employeeGetById(id), HttpStatus.OK);
        }

	@Override
	public ResponseEntity<Employee> createEmployee(Employee employee) {
		log.info("creating a new employee for: {}", employee.toString());
		Integer id = employeeService.createEmployee(employee);
		log.info("employee created: {}", id);
		employee.setId(id);
		try {
			return ResponseEntity.created(getLocationURI(id)).body(employee);
		} catch (URISyntaxException e) {
			throw new EmployeeServiceException();
		}
	}
	
	/**
	 * creates location URI
	 * 
	 * @param id The employee id
	 * @return {@link URI}
	 * @throws URISyntaxException
	 */
	private URI getLocationURI(Integer id) throws URISyntaxException{
		StringBuilder locationBuilder = new StringBuilder(EMPLOYEE_CONTEXT_PATH);
		locationBuilder.append(id);
		return new URI(locationBuilder.toString());
	}

}
