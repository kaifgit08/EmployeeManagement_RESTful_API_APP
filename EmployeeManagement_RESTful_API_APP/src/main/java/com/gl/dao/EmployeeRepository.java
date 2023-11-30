package com.gl.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gl.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	List<Employee> findAllByFirstName(String firstName);

}
