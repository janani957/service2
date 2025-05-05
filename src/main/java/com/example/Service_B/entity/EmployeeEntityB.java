package com.example.Service_B.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class EmployeeEntityB {
	
	@Id
	private int employeeId;
	private String employeeName;
	private Double employeeSalary;
	private long employeePhoneNo;


}
