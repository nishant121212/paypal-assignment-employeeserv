package com.paypal.bfs.test.employeeserv.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.exception.EmployeeNotFoundException;
import com.paypal.bfs.test.employeeserv.repository.EmployeeRepository;
import com.paypal.bfs.test.employeeserv.service.EmployeeService;
import com.paypal.bfs.test.employeeserv.util.TestUtil;
/**
 * 
 * Employee service impl functional test cases
 */
@RunWith(SpringRunner.class)
public class EmployeeServiceImplTest {
	
	@Mock
	private EmployeeRepository employeeRepository;
	
	@InjectMocks
	private EmployeeService employeeService = new EmployeeServiceImpl();
	
	@Test
	public void createEmployee_Success() {
		Employee employee = TestUtil.getTestEmployee(123);
		when(employeeRepository.save(any(com.paypal.bfs.test.employeeserv.entity.Employee.class))).thenReturn(TestUtil.getTestEmployeeEntity(123));
		Integer id = employeeService.createEmployee(TestUtil.getTestEmployeeForPost());
		assertEquals(employee.getId(), id);
	}
	
	@Test
	public void getEmployee_Success() {
		Optional<com.paypal.bfs.test.employeeserv.entity.Employee> employeeOptional = Optional.of(TestUtil.getTestEmployeeEntity(123));
		when(employeeRepository.findById(123)).thenReturn(employeeOptional);
		Employee employee = employeeService.employeeGetById("123");
		assertEquals(employeeOptional.get().getId(), employee.getId());
	}
	
	@Test(expected = EmployeeNotFoundException.class)
	public void getEmployee_EmployeeNotFound() {
		Optional<com.paypal.bfs.test.employeeserv.entity.Employee> employeeOptional = Optional.empty();
		when(employeeRepository.findById(123)).thenReturn(employeeOptional);
		employeeService.employeeGetById("123");
	}
}
