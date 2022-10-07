package com.practice.demo.controller.impl;

import java.util.List;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.demo.config.AppConfig;
import com.practice.demo.controller.EmployeeContoller;
import com.practice.demo.model.Employee;
import com.practice.demo.service.EmployeeService;
@PropertySource("classpath:application.properties")
@CrossOrigin(origins = "${react.origin}")
@RestController
@RequestMapping("/employee/employees/")
public class EmployeeContollerImpl implements EmployeeContoller{
	
	private static final Logger LOGGER = LogManager.getLogger(EmployeeContollerImpl.class);
	
	@Value("${companyInfo.shortName}")
	private String shortName;
	
	
	/*
	 * we can autowire environment and directly use
	 * environment.getProperty("db.driver") from the properties file
	 */
	@Value("${companyInfo.companyName}")
	private String companyName;

	@Autowired
	private AppConfig appConfig;
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	@Override
	public List<Employee> getAllEmployees(){
		LOGGER.info("EmployeeContollerImpl : " + shortName + companyName);
		LOGGER.debug("debug");
		appConfig.source();
		return employeeService.getEmployeesList();
	}
	
	@PostMapping
	@Override
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		LOGGER.debug("inside save employee" + employee);
		return ResponseEntity.ok(employeeService.saveOrUpdate(employee));
	}

	/*
	 * to get param from path use path variable and to get value from query param
	 * use request param
	 * @ModelAttribute is used for binding data from both request param and path variable
	 */
	
//	@GetMapping("/byid")
	@GetMapping("{id}")
	@Override
	public ResponseEntity<Employee> getEmployeebyId( /* @RequestParam */ /* @PathVariable Long id */ 
	 @ModelAttribute Employee emplyee ) throws Exception{
		LOGGER.debug("inside getEmployeebyId with id : " + emplyee.getId());
		Employee emp = employeeService.getEmployeebyId(emplyee.getId());
		return ResponseEntity.ok(emp);
	}
	
	@PutMapping("{id}")
	@Override
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee empDetails) throws Exception{
		LOGGER.debug("inside updateEmployee" + empDetails);
		empDetails.setId(id);
		return ResponseEntity.ok(employeeService.saveOrUpdate(empDetails));
	}
	
	@DeleteMapping("{id}")
	@Override 
	public String deleteEmployee(@PathVariable Long id) throws Exception{
		return employeeService.deleteEmployeeById(id);
	}
	
}
