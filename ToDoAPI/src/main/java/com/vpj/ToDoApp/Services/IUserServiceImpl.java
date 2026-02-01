package com.vpj.ToDoApp.Services;

import java.util.List;

import com.vpj.ToDoApp.DTO.UserDetails;

public interface IUserServiceImpl {

	void AddUser(UserDetails u1);
	void RmUser(int u1);
	List<UserDetails> allUser();
	
}
