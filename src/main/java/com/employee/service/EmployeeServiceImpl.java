package com.employee.service;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.EmployeeDTO;
import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee addEmployee(Employee employee) {
		employeeRepository.save(employee);
		return employee;
	}

	@Override
	public List<EmployeeDTO> getAllEmployees() {

		return calculateSalary(employeeRepository.findAll());
	}

	private List<EmployeeDTO> calculateSalary(List<Employee> empList) {

		Iterator<Employee> itr = empList.iterator();
		EmployeeDTO empDTO = null;
		List<EmployeeDTO> empTaxList = new ArrayList<>();

		while (itr.hasNext()) {

			empDTO = new EmployeeDTO();
			Employee emp = itr.next();
			empDTO.setFirstName(emp.getFirstName());
			empDTO.setLastName(emp.getLastName());
			empDTO.setEmployeeCode(emp.getEmployeeCode());
			// getMonthValueBasedOnDOJ(emp.getDoj());
			double yearSal = 12 * (emp.getSalary());
			empDTO.setYearlySalary(yearSal);

			double tax = 0;

			if (yearSal <= 250000) {
				tax = 0;
				empDTO.setTaxAmount(tax);
				empDTO.setCessAmount(0);

			} else if (yearSal > 250000 && yearSal <= 500000) {
				tax = 0.05 * (yearSal - 250000);
				empDTO.setTaxAmount(tax);
				empDTO.setCessAmount(0);
			} else if (yearSal > 500000 && yearSal <= 1000000) {
				tax = (0.1 * (yearSal - 500000)) + (0.05 * 250000);
				empDTO.setTaxAmount(tax);
				empDTO.setCessAmount(0);
			} else if (yearSal > 1000000 && yearSal <= 2500000) {
				tax = (0.1 * (yearSal - 500000)) + (0.05 * 250000);
				empDTO.setTaxAmount(tax);
				empDTO.setCessAmount(0);
			} else {
				tax = (0.2 * (yearSal - 1000000)) + (0.1 * 500000) + (0.05 * 250000);

				empDTO.setCessAmount(yearSal - 1000000);
				empDTO.setTaxAmount(tax);
				empTaxList.add(empDTO);
			}
			empTaxList.add(empDTO);
		}

		return empTaxList;
	}

//@TODO
	private int getMonthValueBasedOnDOJ(Date date) {
		Instant instant = date.toInstant();
		LocalDate dojDate = LocalDate.parse(instant.toString());
		int oldMonth = dojDate.getMonthValue();

		Instant currentInstant = new Date().toInstant();
		LocalDate currentDate = LocalDate.parse(currentInstant.toString());
		int currentMonth = currentDate.getMonthValue();

		return currentMonth - oldMonth;

	}

}
