package com.study.todo.controller;

import com.study.todo.entity.Todo;
import com.study.todo.services.ToDoServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@Slf4j
public class TodoController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ToDoServices toDoServices;

    @Value("${todo.api.url}")
    private String baseUrl;

    @GetMapping("/getAllToDos")
    public List<Todo> getAllToDos() {
        ResponseEntity<List<Todo>> response = restTemplate.exchange(
                ""
                , HttpMethod.GET
                , null
                ,
                new ParameterizedTypeReference<List<Todo>>() {
                });

        List<Todo> todoList = response.getBody();

        log.info("Todo List: {}", todoList.size());

        return todoList;

    }

    @GetMapping("/getToDoById/{id}")
    public Todo getToDoById(@PathVariable(name = "id") Long id) {
        String url = baseUrl + "/{id}";

        return restTemplate.getForObject(url,Todo.class,id);
    }

    public void createToDo(Todo todo) {

    }


    @GetMapping("/{id}")
    public Todo getTodo(@PathVariable Long id) {
        return toDoServices.getTodo(id);
    }

    @GetMapping()
    public List<Todo> getEachTodo() {
        return toDoServices.getAllTodo();
    }
}
