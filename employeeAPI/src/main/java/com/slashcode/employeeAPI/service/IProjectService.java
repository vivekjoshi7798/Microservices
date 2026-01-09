package com.slashcode.employeeAPI.service;

import java.util.List;

import com.slashcode.employeeAPI.DTO.Project;


public interface IProjectService {

	List<Project> getAllProject();

	void Add_project(Project p);

	void Update_project(Project p);

	void Delete_project(int proj_id);

	Project getAllProject(int iD);

	List<Project> getProjectForEmployee(int emp_ID);


}
