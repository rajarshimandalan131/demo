package com.practice.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.practice.demo.model.Employee;

public interface EmployeeContoller {

	List<Employee> getAllEmployees();

	ResponseEntity<Employee> createEmployee(Employee employee);

//	ResponseEntity<Employee> getEmployeebyId(Long id) throws Exception;

	ResponseEntity<Employee> updateEmployee(Long id, Employee empDetails) throws Exception;

	String deleteEmployee(Long id) throws Exception;

	ResponseEntity<Employee> getEmployeebyId(Employee emplyee) throws Exception;

}
