package com.study.todo.services;

import com.study.todo.entity.Todo;
import com.study.todo.feingClient.TodoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoServices {

    @Autowired
    TodoClient todoClient;

    public Todo getTodo(Long id) {
        return  todoClient.getTodoById(id);
    }

    public List<Todo> getAllTodo() {
        return  todoClient.getAllTodos();
    }
}
