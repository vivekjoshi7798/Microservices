package com.slashcode.employeeAPI.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.slashcode.employeeAPI.DTO.Employee;

@Repository
public interface IemployeeDao extends JpaRepository<Employee,Integer>{

	List<Employee> findBydeptName(String Dept);
	
}
