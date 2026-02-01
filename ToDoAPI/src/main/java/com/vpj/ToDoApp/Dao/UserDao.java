package com.vpj.ToDoApp.Dao;

import org.springframework.stereotype.Repository;

import com.vpj.ToDoApp.DTO.UserDetails;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserDao extends JpaRepository<UserDetails,Integer>{
	
}
