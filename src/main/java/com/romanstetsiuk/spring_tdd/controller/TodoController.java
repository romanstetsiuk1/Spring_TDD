package com.romanstetsiuk.spring_tdd.controller;

import com.romanstetsiuk.spring_tdd.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TodoController {

    @Autowired
    TodoService todoService;

    @GetMapping("/todosView")
    String getTodosView(Model model) {
        model.addAttribute("list: ", todoService.findAll());
        return "todos";
    }

}
