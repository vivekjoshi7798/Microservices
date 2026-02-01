package com.vpj.ToDoApp.Services;

import java.util.List;

import com.vpj.ToDoApp.DTO.Task;

public interface ITaskServiceImpl {

	List<Task> getAllTask();
	Task getAllTaskById(int taskID);
	String addTask(Task T);
	String RmTasksById(int I);
	String EditTask(Task T);

}
