package com.slashcode.employeeAPI.DTO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Project {

	@Id
	private int mProject_id;
	private String mProjectName;
	
	@ManyToOne
	private Employee employee;
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Project() {
		
	}
	
	public Project(int mProject_id, String mProjectName,int emp_id) {
		super();
		this.mProject_id = mProject_id;
		this.mProjectName = mProjectName;
		this.employee= new Employee(emp_id,"","");
	}
	
	public int getmProject_id() {
		return mProject_id;
	}
	public void setmProject_id(int mProject_id) {
		this.mProject_id = mProject_id;
	}
	public String getmProjectName() {
		return mProjectName;
	}
	public void setmProjectName(String mProjectName) {
		this.mProjectName = mProjectName;
	}
	
	
	
	
	
	
}
