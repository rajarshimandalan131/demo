package com.practice.demo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.practice.demo.repository.EmployeeRepository;

@Component
public class RepositoryFactory {

	@Autowired
	EmployeeRepository employeeRepository;

	public EmployeeRepository getEmployeeRepository() {
		// TODO Auto-generated method stub
		return employeeRepository;
	}
	
	

}
