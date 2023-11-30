package com.gl.service;

import java.util.List;

import com.gl.entity.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployee();

	Employee getEmployeeById(int id);

	String deleteEmployeeById(int id);

	String updateEmployeeById(Employee updatedEmployee);

	String saveEmployee(Employee employee);

	public List<Employee> getAllEmployeeSortByFirstName(String order);

	public List<Employee> getAllEmployeeSearchByFirstName(String firstName);


}