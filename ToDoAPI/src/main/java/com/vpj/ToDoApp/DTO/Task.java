package com.vpj.ToDoApp.DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Formatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","dt"})
public class Task {

	@Id
	@GeneratedValue
	private int taskId;
	private String taskTitle;
	private String taskDescription;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date dt;
	

	@ManyToOne
	private UserDetails user ;

	
	Task(){}


	public int getTaskId() {
		return taskId;
	}


	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}


	public String getTaskTitle() {
		return taskTitle;
	}


	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}


	public String getTaskDescription() {
		return taskDescription;
	}


	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}




	public Date getDt() {
		return dt;
	}


	public void setDt(Date dt) {
		this.dt = dt;
	}


	public UserDetails getUser() {
		return user;
	}


	public void setUser(UserDetails user) {
		this.user = user;
	}


	public Task(int taskId, String taskTitle, String taskDescription, Date dt, UserDetails user) {
		super();
		this.taskId = taskId;
		this.taskTitle = taskTitle;
		this.taskDescription = taskDescription;
		dt = dt;
		this.user = user;
	}


}