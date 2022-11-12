package com.employee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.EmployeeDTO;
import com.employee.model.Employee;

@Service
public interface EmployeeService {

	public Employee addEmployee(Employee employee);

	public List<EmployeeDTO> getAllEmployees();
}
