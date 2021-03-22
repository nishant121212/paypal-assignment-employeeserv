package com.paypal.bfs.test.employeeserv.mapper;

import com.paypal.bfs.test.employeeserv.api.model.Address;
import com.paypal.bfs.test.employeeserv.api.model.Employee;

/**
 * Employee mapper class
 *
 */
public class EmployeeMapper {
	
	/**
	 * private EmployeeMapper Constructor
	 */
	private EmployeeMapper() {}
	
	/**
	 * Maps Entity {@link com.paypal.bfs.test.employeeserv.entity.Employee} to employee sevice model {@link Employee}
	 * 
	 * @param employee {@link com.paypal.bfs.test.employeeserv.entity.Employee}
	 * @return {@link Employee}
	 */
	public static Employee mapEntityToModel(com.paypal.bfs.test.employeeserv.entity.Employee employee) {
		Employee employeeModel = new Employee();
		employeeModel.setId(employee.getId());
		employeeModel.setFirstName(employee.getFirstName());
		employeeModel.setLastName(employee.getLastName());
		employeeModel.setDateOfBirth(employee.getDateOfBirth());
		Address address = new Address();
		address.setLine1(employee.getAddressLine1());
		address.setLine2(employee.getAddressLine2());
		address.setCity(employee.getCity());
		address.setState(employee.getState());
		address.setCountry(employee.getCountry());
		address.setZipCode(employee.getZipCode());
		employeeModel.setAddress(address);
		return employeeModel;
        }
	
	/**
	 * Maps Employee service model {@link Employee} to entity {@link com.paypal.bfs.test.employeeserv.entity.Employee}
	 * 
	 * @param employee {@link Employee}
	 * @return {@link com.paypal.bfs.test.employeeserv.entity.Employee}
	 */
	public static com.paypal.bfs.test.employeeserv.entity.Employee mapModelToEntity(Employee employee){
		com.paypal.bfs.test.employeeserv.entity.Employee employeeEntity = new com.paypal.bfs.test.employeeserv.entity.Employee();
		employeeEntity.setId(employee.getId());
		employeeEntity.setFirstName(employee.getFirstName());
		employeeEntity.setLastName(employee.getLastName());
		employeeEntity.setDateOfBirth(employee.getDateOfBirth());
		employeeEntity.setAddressLine1(employee.getAddress().getLine1());
		employeeEntity.setAddressLine2(employee.getAddress().getLine2());
		employeeEntity.setCity(employee.getAddress().getCity());
		employeeEntity.setState(employee.getAddress().getState());
		employeeEntity.setCountry(employee.getAddress().getCountry());
		employeeEntity.setZipCode(employee.getAddress().getZipCode());
		return employeeEntity;
	}
	
}
