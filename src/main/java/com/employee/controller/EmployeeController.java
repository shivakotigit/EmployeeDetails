package com.employee.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.employee.EmployeeDTO;
import com.employee.model.Employee;
import com.employee.service.EmployeeService;

@Controller
@ResponseBody
@RequestMapping("/api/v1")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/createEmployee")
	public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
		Employee employees = employeeService.addEmployee(employee);
		return new ResponseEntity<>(employees, HttpStatus.CREATED);
	}

	@GetMapping("/getEmployees")
	public List<EmployeeDTO> getAllEmployees() {
		return employeeService.getAllEmployees();
	}
}
