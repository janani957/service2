package com.example.Service_B.ServiceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.Service_B.ServiceInter.EmployeeServiceInterServiceB;
import com.example.Service_B.dto.EmployeeDtoB;
import com.example.Service_B.entity.EmployeeEntityB;
import com.example.Service_B.repository.EmployeeRepositoryServiceB;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class EmployeeServiceImplServiceB implements EmployeeServiceInterServiceB {
	
	@Autowired
	EmployeeRepositoryServiceB employeeRepositoryServiceB;
	
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	private ModelMapper modelMapper;
	
	public EmployeeDtoB saveEmployeeB(EmployeeDtoB employeeDtoB) {
		log.info("Starting to save Employee in DB: {}", employeeDtoB);
		employeeRepositoryServiceB.save(convertDtoToEntity(employeeDtoB));
		log.info("Employee saved in DB: {}", employeeDtoB);
		EmployeeDtoB employeeResponse =restTemplate.postForEntity("http://localhost:8890/saveEmployeeA", employeeDtoB, EmployeeDtoB.class).getBody();
		log.info("Response received from Service A: {}",employeeResponse);
		return employeeResponse;
	}
	
	public EmployeeDtoB convertEntityToDto(EmployeeEntityB employeeEntityB) {
		return modelMapper.map(employeeEntityB, EmployeeDtoB.class);
	}
	
	public EmployeeEntityB convertDtoToEntity(EmployeeDtoB employeeDtoB) {
		return modelMapper.map(employeeDtoB, EmployeeEntityB.class);
	}


}
