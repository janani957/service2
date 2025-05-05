package com.example.Service_B.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Service_B.ServiceInter.EmployeeServiceInterServiceB;
import com.example.Service_B.dto.EmployeeDtoB;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
public class EmployeeControllerServiceB {
	
	@Autowired
	EmployeeServiceInterServiceB employeeServiceInterServiceB;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@PostMapping("/saveEmployeeB")
	public EmployeeDtoB saveEmployeeB(@RequestBody EmployeeDtoB employeeDtoB) {
		log.info("Received request to save Employee: {}", employeeDtoB);
		employeeDtoB = employeeServiceInterServiceB.saveEmployeeB(employeeDtoB);
		log.info("Employee saved successfully: {}", employeeDtoB);
		return employeeDtoB;
	}
}
