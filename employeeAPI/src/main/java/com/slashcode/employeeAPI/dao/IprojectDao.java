package com.slashcode.employeeAPI.dao;

import java.util.List;
import com.slashcode.employeeAPI.DTO.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.slashcode.employeeAPI.DTO.Employee;
import com.slashcode.employeeAPI.DTO.Project;

@Repository
public interface IprojectDao extends JpaRepository<Project,Integer>{
	
	List<Project>  findByEmployeeEmpid(int emp_id);
}
