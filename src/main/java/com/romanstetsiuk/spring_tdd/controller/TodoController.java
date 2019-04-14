package com.romanstetsiuk.spring_tdd.controller;

import com.romanstetsiuk.spring_tdd.model.ToDo;
import com.romanstetsiuk.spring_tdd.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.EntityNotFoundException;

@Controller
public class TodoController {

    @Autowired
    TodoService todoService;

    @GetMapping("/todosView")
    String getTodosView(Model model) {
        model.addAttribute("list", todoService.findAll());
        return "todos";
    }

    @GetMapping("/todoDetails/{id}")
    String getOneTodoDetails(Model model, @PathVariable("id") Long id) {
        ToDo toDo = todoService
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);

        model.addAttribute("singleTodo", toDo);

        return "todoDetails";
    }

}
