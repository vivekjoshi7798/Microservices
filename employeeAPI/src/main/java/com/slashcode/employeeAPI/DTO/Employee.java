package com.slashcode.employeeAPI.DTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employee {

	@Id
	@GeneratedValue
	private int empid;
	private String empname;
	private String deptName;
	
	
	public Employee() {
	
	}
	
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public Employee(int empid, String empname, String deptName) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.deptName = deptName;
	}
	

	
}
