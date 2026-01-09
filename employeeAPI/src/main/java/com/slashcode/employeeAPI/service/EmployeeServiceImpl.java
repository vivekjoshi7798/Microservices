package com.slashcode.employeeAPI.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slashcode.employeeAPI.DTO.Employee;
import com.slashcode.employeeAPI.dao.IemployeeDao;

@Service
public class EmployeeServiceImpl  implements IEmployeeService {
	
	List<Employee> empList=  new ArrayList<> (Arrays.asList(new Employee(1,"VIVEK","VodaFone"),
			new Employee(2,"Ram","DSK"),
			new Employee(3,"Gita","Principle"),
			new Employee(4,"Sham","amdocs")));

	@Autowired
	private IemployeeDao Daoref;
	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return Daoref.findAll();
	}

	@Override
	public Employee getAllEmployeeById(int emp_ID) {
		
	
		return Daoref.getOne(emp_ID);
		
	}

	@Override
	public void AddEmployee(Employee e1) {
		// TODO Auto-generated method stub
		Daoref.save(e1);
	}

	@Override
	public void Update_Employee(Employee e, int emp_id) {
		
//		for ( Employee E1 : empList)
//		{
//			if (E1.getEmp_id() == emp_id) {
//				empList.set(empList.indexOf(E1), e);
//			}		
//		}
		
		Daoref.save(e);
		
	}

	@Override
	public void Remove_Employee(int emp_id) {
		Daoref.deleteById(emp_id);
	
	}

	@Override
	public List<Employee> getEmployeeByDept(String Dept_name) {
		// TODO Auto-generated method stub
		return Daoref.findBydeptName(Dept_name);
	}
}
