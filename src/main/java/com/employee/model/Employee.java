package com.employee.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "emp_tbl")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer employeeCode;
	@NotEmpty(message = "First name should not be empty.")
	private String firstName;
	@NotEmpty(message = "Last name should not be empty.")
	private String lastName;
	@NotEmpty(message = "Email name should not be empty.")
	@Email
	@JsonIgnore
	@JsonProperty(value = "email")
	private String email;
	@NotNull
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date doj;

	@NotEmpty(message = "PhoneNumbers should not be empty.")
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "employeeCode")
	@OrderColumn(name = "type")
	private List<PhoneNumber> phoneNumbers;

	@NotNull
	private Double salary;

	public Integer getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(Integer employeeCode) {
		this.employeeCode = employeeCode;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public List<PhoneNumber> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	/*
	 * public List<Long> getPhoneNumbers() { return phoneNumbers; }
	 * 
	 * public void setPhoneNumbers(List<Long> phoneNumbers) { this.phoneNumbers =
	 * phoneNumbers; }
	 */

}
