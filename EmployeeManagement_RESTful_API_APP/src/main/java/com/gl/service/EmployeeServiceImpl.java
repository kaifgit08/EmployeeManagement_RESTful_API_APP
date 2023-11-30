package com.gl.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.gl.dao.EmployeeRepository;
import com.gl.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository dao;

	@Override
	public List<Employee> getAllEmployee() {
		return dao.findAll();

	}

	@Override
	public Employee getEmployeeById(int id) {
		Optional<Employee> employee = dao.findById(id);
		if (employee.isPresent()) {
			return dao.findById(id).get();
		}

		return null;

	}

	@Override
	public String deleteEmployeeById(int id) {
		Optional<Employee> employee = dao.findById(id);
		if (employee.isPresent()) {
			dao.deleteById(id);
			return "Deleted employee id - " + id;

		}

		return "Id not found";

	}

	@Override
	public String updateEmployeeById(Employee updatedEmployee) {
		int id = updatedEmployee.getId();
		Optional<Employee> employee = dao.findById(id);
		if (employee.isPresent()) {
			dao.save(updatedEmployee);
			return "Updated Successfully";

		}

		return "Id not found";

	}

	@Override
	public String saveEmployee(Employee employee) {
		int id = employee.getId();
		Optional<Employee> existEmployee = dao.findById(id);
		if (existEmployee.isPresent())
			return "Already employee id exists.If you want to update,use update option";
		else {
			dao.save(employee);
			return "New Employee added Successfully";
		}
	}

	@Override
	public List<Employee> getAllEmployeeSearchByFirstName(String firstName) {
		return dao.findAllByFirstName(firstName);

	}

	public List<Employee> getAllEmployeeSortByFirstName(String order) {
		System.out.println(order);

		if (order.toUpperCase().equals("\"DESC\""))
			return dao.findAll(Sort.by(Sort.Direction.DESC, "firstName"));
		else
			return dao.findAll(Sort.by(Sort.Direction.ASC, "firstName"));

	}
}
