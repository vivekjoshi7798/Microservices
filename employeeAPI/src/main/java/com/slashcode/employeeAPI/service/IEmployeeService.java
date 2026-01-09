package com.slashcode.employeeAPI.service;

import java.util.List;

import com.slashcode.employeeAPI.DTO.Employee;

public interface IEmployeeService {

	public List<Employee> getAllEmployee();

	public Employee getAllEmployeeById(int emp_ID);

	public void AddEmployee(Employee e1);

	public void Update_Employee(Employee e1, int emp_id);

	public void Remove_Employee(int emp_id);

	public List<Employee>  getEmployeeByDept(String Dept_name);




}
