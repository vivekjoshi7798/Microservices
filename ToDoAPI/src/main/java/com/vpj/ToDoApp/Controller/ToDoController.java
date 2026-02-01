package com.vpj.ToDoApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vpj.ToDoApp.DTO.Task;
import com.vpj.ToDoApp.DTO.UserDetails;
import com.vpj.ToDoApp.Services.ITaskServiceImpl;
import com.vpj.ToDoApp.Services.IUserServiceImpl;

import java.util.*;

@RestController
public class ToDoController {
	
	
	@Autowired
	IUserServiceImpl UserService;
	
	@Autowired
	ITaskServiceImpl TaskService;
	
	@RequestMapping(method = RequestMethod.GET, value = "hello")
	public String getHello()
	{
		return "Hello John ! How are you ?";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "GetTasks")
	public List<Task> GetTask()
	{
		return TaskService.getAllTask();
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value = "GetTask/{TaskID}")
	public Task GetTaskById(@PathVariable int TaskID)
	{
		return  TaskService.getAllTaskById(TaskID);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "AddTask")
	public String AddTask(@RequestBody Task T)
	{
		return TaskService.addTask(T);
	}
	

	
	@RequestMapping(method = RequestMethod.PUT, value = "EditTasks/{TaskID}")
	public String EditTasksById(@RequestBody Task T )
	{
		return TaskService.EditTask(T);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "RmTasks/{TaskID}")
	public String RmTasksById(@PathVariable int TaskID)
	{
		return TaskService.RmTasksById(TaskID);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value = "AddUser")
	public void AddUser(@RequestBody UserDetails userID)
	{

		UserService.AddUser(userID);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "RmUser/{UserID}")
	public void RmUser(@PathVariable("UserID") int userID)
	{
		UserService.RmUser(userID);
	}
	@RequestMapping(method = RequestMethod.GET, value = "GetUser")
	public List<UserDetails> GetUser()
	{
		return UserService.allUser();
	}
	
}
