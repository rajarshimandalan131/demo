package com.practice.demo.service.impl;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Service;

import com.practice.demo.exception.ResourceNotFoundException;
import com.practice.demo.model.Employee;
import com.practice.demo.service.EmployeeService;
import com.practice.demo.utils.RepositoryFactory;

@Service
public class EmployeeServiceImpl implements EmployeeService, HealthIndicator{

	@Autowired
	RepositoryFactory repositoryFactory;
	
	@Override
	public List<Employee> getEmployeesList() {
		return repositoryFactory.getEmployeeRepository().findAll();
	}

	@Override
	public Employee saveOrUpdate(Employee employee) {
		return repositoryFactory.getEmployeeRepository().save(employee);
	}

	@Override
	public Employee getEmployeebyId(Long id) {
		return repositoryFactory.getEmployeeRepository().findById(id)
				.orElseThrow(new Supplier<ResourceNotFoundException>() {
					@Override
					public ResourceNotFoundException get() {
						return new ResourceNotFoundException("Employee with id " + id + " does not exist");
					}
				});
	}

	@Override
	public String deleteEmployeeById(Long id) {
		try {
			repositoryFactory.getEmployeeRepository().deleteById(id);
			return "SUCCESS";
		} catch (Exception e) {
			e.printStackTrace();
			return "FAILED";
		}
	}

	@Override
	public Health health() {
		return Health.up().withDetail("EmployeeService", "EmployeeService is up and running").build();
	}

}
