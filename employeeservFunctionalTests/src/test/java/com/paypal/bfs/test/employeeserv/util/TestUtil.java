package com.paypal.bfs.test.employeeserv.util;

import java.util.Date;

import com.paypal.bfs.test.employeeserv.api.model.Address;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.mapper.EmployeeMapper;

public class TestUtil {
	
	private TestUtil() {}
	
	public static Employee getTestEmployee(Integer id) {
		Employee employeeModel = new Employee();
    	employeeModel.setId(id);
    	employeeModel.setFirstName("test fname");
    	employeeModel.setLastName("test lname");
    	employeeModel.setDateOfBirth(new Date());
        Address address = new Address();
        address.setLine1("test address line1");
        address.setLine2("test address line2");
        address.setCity("test address city");
        address.setState("test address state");
        address.setCountry("test address country");
        address.setZipCode(110032);
        employeeModel.setAddress(address);
        return employeeModel;
	}
	
	public static Employee getTestEmployeeForPost() {
		Employee employeeModel = new Employee();
    	employeeModel.setFirstName("test fname");
    	employeeModel.setLastName("test lname");
    	employeeModel.setDateOfBirth(new Date());
        Address address = new Address();
        address.setLine1("test address line1");
        address.setLine2("test address line2");
        address.setCity("test address city");
        address.setState("test address state");
        address.setCountry("test address country");
        address.setZipCode(110032);
        employeeModel.setAddress(address);
        return employeeModel;
	}
	
	public static com.paypal.bfs.test.employeeserv.entity.Employee getTestEmployeeEntity(Integer id){
		return EmployeeMapper.mapModelToEntity(getTestEmployee(id));
	}

}
