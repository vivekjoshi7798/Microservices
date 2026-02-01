package com.vpj.ToDoApp.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vpj.ToDoApp.DTO.Task;

@Repository
public interface TaskDao extends JpaRepository<Task,Integer>{

}
