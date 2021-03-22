package com.paypal.bfs.test.employeeserv.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * 
 * Employee entity class
 *
 */
@Entity
@Table(name = "EMPLOYEES")
@Data
public class Employee {

	/**
	 * employee id
	 */
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	/**
	 * first name
	 */
	@Column(name = "first_name")
    private String firstName;
    /**
     * last name
     * (Required)
     * 
     */
	@Column(name = "last_name")
    private String lastName;
    /**
     * date of birth
     * (Required)
     * 
     */
	@Column(name = "dateOfBirth")
    private Date dateOfBirth;
    /**
     * address line1
     * (Required)
     * 
     */
	@Column(name = "address_line1")
    private String addressLine1;
    /**
     * address line2
     * 
     */
	@Column(name = "address_line2")
    private String addressLine2;
    /**
     * address city
     * (Required)
     * 
     */
	@Column(name = "city")
    private String city;
    /**
     * address state
     * (Required)
     * 
     */
	@Column(name = "state")
    private String state;
    /**
     * address country
     * (Required)
     * 
     */
	@Column(name = "country")
    private String country;
    /**
     * address zip code
     * (Required)
     * 
     */
	@Column(name = "zipcode")
    private Integer zipCode;
	
}
