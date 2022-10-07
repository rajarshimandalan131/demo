package com.practice.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.demo.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
