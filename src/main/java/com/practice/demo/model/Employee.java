package com.practice.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "employee")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee extends AuditProperties{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ToString.Exclude
	private long id;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "emailId")
	private String emailId;
	
//	public Employee() {}
	
//	public Employee(String firstName, String lastName, String emailId) {
//		super();
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.emailId = emailId;
//	}

//	@Override
//	public String toString() {
//		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
//				+ "]";
//	}
	
	
}
