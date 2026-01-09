package com.slashcode.employeeAPI.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.slashcode.employeeAPI.DTO.*;
import com.slashcode.employeeAPI.dao.*;

@Service
public class ProjectserviceImpl  implements IProjectService {

	@Autowired
	IprojectDao ProjectDevRef;
	@Override
	public List<Project> getAllProject() {
		// TODO Auto-generated method stub
		return ProjectDevRef.findAll();
	}
	@Override
	public void Add_project(Project p) {
		ProjectDevRef.save(p);
		
	}
	@Override
	public void Update_project(Project p) {
		ProjectDevRef.save(p);
		
	}
	@Override
	public void Delete_project(int proj_id) {
		// TODO Auto-generated method stub
		
		ProjectDevRef.deleteById(proj_id);
		
	}
	@Override
	public Project getAllProject(int iD) {
		// TODO Auto-generated method stub
		return ProjectDevRef.getOne(iD);
	}
	@Override
	public List<Project> getProjectForEmployee(int emp_ID) {
		// TODO Auto-generated method stub
		return ProjectDevRef.findByEmployeeEmpid(emp_ID);
	}
	

}
