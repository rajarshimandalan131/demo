package com.practice.demo.service;

import java.util.List;

import com.practice.demo.model.Employee;

public interface EmployeeService {

	List<Employee> getEmployeesList();

	Employee saveOrUpdate(Employee employee);

	Employee getEmployeebyId(Long id) throws Exception;

	String deleteEmployeeById(Long id);

}
