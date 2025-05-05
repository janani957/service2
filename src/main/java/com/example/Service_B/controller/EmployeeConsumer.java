package com.example.Service_B.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.example.Service_B.dto.EmployeeDtoB;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class EmployeeConsumer {
	
	@Autowired
	ObjectMapper objectMapper;

	@KafkaListener(topics = "Employee-service",groupId = "My_Group")
	public void saveEmployee(String employeeDto) {
		log.info("Received message from Kafka topic 'EmployeeService': {}", employeeDto);
		try {
			EmployeeDtoB employeeDtoB =objectMapper.readValue(employeeDto, EmployeeDtoB.class);
			log.info("Successfully deserialized Kafka message to EmployeeDtoB: {}", employeeDtoB);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
