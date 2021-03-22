package com.paypal.bfs.test.employeeserv.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.paypal.bfs.test.employeeserv.api.EmployeeResource;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.service.EmployeeService;
import com.paypal.bfs.test.employeeserv.util.TestUtil;

/**
 * 
 * Employee Resource Impl functional test cases
 */
@RunWith(SpringRunner.class)
public class EmployeeResourceImplTest {
	
	@Mock
	private EmployeeService employeeService;
	
	@InjectMocks
	private EmployeeResource employeeResource = new EmployeeResourceImpl();
	
	@Test
	public void createEmployee_Success() {
		Employee employee = TestUtil.getTestEmployeeForPost();
		when(employeeService.createEmployee(any(Employee.class))).thenReturn(123);
		ResponseEntity<Employee> employeeResponseEntity = employeeResource.createEmployee(employee);
		assertSame(employee, employeeResponseEntity.getBody());
		assertEquals(Integer.valueOf(123), employeeResponseEntity.getBody().getId());
		assertEquals(HttpStatus.CREATED, employeeResponseEntity.getStatusCode());
		String location = "/v1/bfs/employees/123";
		assertEquals(location, employeeResponseEntity.getHeaders().getLocation().toString());
	}
	
	@Test
	public void getEmployee_Success() {
		Employee employee = TestUtil.getTestEmployee(123);
		when(employeeService.employeeGetById("123")).thenReturn(employee);
		ResponseEntity<Employee> employeeResponseEntity = employeeResource.employeeGetById("123");
		assertEquals(employee, employeeResponseEntity.getBody());
		assertEquals(Integer.valueOf(123), employeeResponseEntity.getBody().getId());
		assertEquals(HttpStatus.OK, employeeResponseEntity.getStatusCode());
	}
	
}
