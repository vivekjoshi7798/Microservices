package com.slashcode.employeeAPI.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.slashcode.employeeAPI.DTO.Employee;
import com.slashcode.employeeAPI.DTO.Project;
import com.slashcode.employeeAPI.service.IEmployeeService;
import com.slashcode.employeeAPI.service.IProjectService;

@RestController
public class ProjectController {

	@Autowired
	IProjectService mprojService;
	
	@RequestMapping("Get_Project")
	public List<Project> getAllProject()
	{ 
		return mprojService.getAllProject();
		
	}
	
	@RequestMapping("Get_Project/{ID}")
	public Project getAllProject(@PathVariable int ID)
	{ 
		return mprojService.getAllProject(ID);
		
	}
	
	@RequestMapping("Get_Employee/{EmployeeId}/projects")
	public List<Project> getAllEmployeeById(@PathVariable("EmployeeId") int Emp_ID)
	{ 
		System.out.println("Employee _ID"+Emp_ID);
		return mprojService.getProjectForEmployee(Emp_ID);
		
	}
	

	@RequestMapping(method=RequestMethod.POST,value="Add_Project/{EMP_ID}")
	public void  Add_project(@RequestBody Project P,@PathVariable int EMP_ID)
	{
		P.setEmployee(new Employee(EMP_ID," "," "));
		mprojService.Add_project(P);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="Update_project/{EMP_ID}")
	public void  Update_project(@RequestBody Project P,@PathVariable int EMP_ID)
	{
		P.setEmployee(new Employee(EMP_ID," "," "));
		mprojService.Update_project(P);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="Delete_Project/{Proj_id}")
	public void  Delete_project(@PathVariable int Proj_id)
	{
		try {
		mprojService.Delete_project(Proj_id);
		}
		catch(Exception e)
		{
			System.out.println("Exception Found"+e);
		}
		}
	
	
	
	
}
