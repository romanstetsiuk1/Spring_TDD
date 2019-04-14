package com.romanstetsiuk.spring_tdd.controller;

import com.romanstetsiuk.spring_tdd.model.ToDo;
import com.romanstetsiuk.spring_tdd.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoRestController {

    @Autowired
    TodoService todoService;

    @GetMapping("todos")
    ResponseEntity<List<ToDo>> getAll() {
        return ResponseEntity.ok()
                .body(todoService.findAll());
    }

}
