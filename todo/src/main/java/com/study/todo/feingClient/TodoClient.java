package com.study.todo.feingClient;

import com.study.todo.entity.Todo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "todo-client", url = "${todo.api.url}")
public interface TodoClient {

    @GetMapping("/{id}")
    Todo getTodoById(@PathVariable("id") Long id);

    @GetMapping
    List<Todo> getAllTodos();
}
