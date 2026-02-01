package com.vpj.ToDoApp.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vpj.ToDoApp.DTO.Task;
import com.vpj.ToDoApp.Dao.TaskDao;

@Service 
public class TaskServiceImpl implements ITaskServiceImpl {

	@Autowired
	TaskDao taskdao;
	@Override
	public List<Task> getAllTask() {
		// TODO Auto-generated method stub
		return taskdao.findAll();
	}

	@SuppressWarnings("deprecation")
	@Override
	public Task getAllTaskById(int taskID) {
		// TODO Auto-generated method stub
		return taskdao.getOne(taskID);
	}

	@Override
	public String addTask(Task t ) {
		// TODO Auto-generated method stub
		taskdao.save(t);
		return  "Data Added" ;
	}

	@Override
	public String EditTask(Task T) {
		// TODO Auto-generated method stub
		taskdao.save(T);
		return  "Data Updated" ;
	}

	@Override
	public String RmTasksById(int  I) {
		// TODO Auto-generated method stub
		taskdao.deleteById(I);
		return "Data Removed";
	}

}
