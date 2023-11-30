package com.gl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gl.entity.Employee;
import com.gl.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	@Autowired
	EmployeeService service;

	@RequestMapping("/")
	public String welcome() {
		return "This is my first Rest Api Application";
	}

	@GetMapping("/employees")
	List<Employee> getAllEmployee() {
		return service.getAllEmployee();
	}

	@GetMapping("/employees/{id}")
	Employee getEmployeeById(@PathVariable int id) {
		return service.getEmployeeById(id);

	}

	@DeleteMapping("/employees/{id}")
	String deleteEmployeeById(@PathVariable int id) {
		return service.deleteEmployeeById(id);
	}

	@PutMapping("/employees")
	String updateEmployeeById(@RequestBody Employee updatedEmployee) {
		return service.updateEmployeeById(updatedEmployee);
	}

	@PostMapping("/employees")
	String saveEmployee(@RequestBody Employee employee) {
		return service.saveEmployee(employee);
	}

	@GetMapping("/employees/search/{firstName}")
	public List<Employee> getAllEmployeeSearchByFirstName(@PathVariable String firstName) {
		return service.getAllEmployeeSearchByFirstName(firstName);

	}

	@GetMapping("/employees/sort{order}")
	public List<Employee> getAllEmployeeBySortByFirstName(@RequestParam String order) {
		return service.getAllEmployeeSortByFirstName(order);

	}



}
