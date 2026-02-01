package com.vpj.ToDoApp.Services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vpj.ToDoApp.DTO.UserDetails;
import com.vpj.ToDoApp.Dao.*;
@Service 
public class UserServiceImpl  implements IUserServiceImpl{
	
	@Autowired
	 private UserDao userdata;
	 
	@Override
	public void AddUser(UserDetails u1) {
		
		System.out.println(u1);
		userdata.save(u1);
		
	} 

	@Override
	public void RmUser(int u1) {
		userdata.deleteById(u1);
	}

	@Override
	public List<UserDetails> allUser() {
		// TODO Auto-generated method stub
		return userdata.findAll();
	}

	
}
