package com.example.Service_B.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Service_B.entity.EmployeeEntityB;

public interface EmployeeRepositoryServiceB extends JpaRepository<EmployeeEntityB, Integer> {

}
