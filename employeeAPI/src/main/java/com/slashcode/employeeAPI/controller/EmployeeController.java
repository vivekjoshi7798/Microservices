package com.slashcode.employeeAPI.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.slashcode.employeeAPI.DTO.Employee;
import com.slashcode.employeeAPI.service.IEmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	IEmployeeService empSer;
	
	@RequestMapping("Welcome")
	public String Welcome()
	{
		return "Hello Employee";
	}
	
	@RequestMapping("Get_Employee")
	public List<Employee> getAllEmployee()
	{ 
		System.out.print("Object Created By Autowired "+empSer.getClass());
		return empSer.getAllEmployee();
		
	}
	
	@RequestMapping("Get_Employee/{EmployeeId}")
	public Employee getAllEmployeeById(@PathVariable("EmployeeId") int Emp_ID)
	{ 
		return empSer.getAllEmployeeById(Emp_ID);
		
	}
	
	@RequestMapping(method = RequestMethod.POST ,value = "Add_Employee") 
	public List<Employee>  AddEmployee(@RequestBody Employee E1)
	{
		empSer.AddEmployee(E1);
		return empSer.getAllEmployee();
	}
	
	@RequestMapping(method = RequestMethod.PUT ,value = "Update_Employee/{Emp_id}") 
	public List<Employee>  Update_Employee(@RequestBody Employee E1,@PathVariable int Emp_id)
	{
		empSer.Update_Employee(E1,Emp_id);
		return empSer.getAllEmployee();
	}
	
	@RequestMapping(method = RequestMethod.DELETE ,value = "Remove_Employee/{Emp_id}") 
	public List<Employee>  Remove_Employee(@PathVariable int Emp_id)
	{
		empSer.Remove_Employee(Emp_id);
		return empSer.getAllEmployee();
	}
	
	@RequestMapping(method = RequestMethod.GET ,value="Get_Employee/dept/{Dept_name}")
	public List<Employee>  getEmployeeByDept(@PathVariable("Dept_name") String  Dept_name)
	{ 
		return empSer.getEmployeeByDept(Dept_name);
		
	}
	
	
}
