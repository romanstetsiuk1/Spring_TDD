package com.romanstetsiuk.spring_tdd.controller;

import com.romanstetsiuk.spring_tdd.model.ToDo;
import com.romanstetsiuk.spring_tdd.service.TodoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class TodoControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    TodoService todoService;

    @Test
    public void findAllValidTest() throws Exception {
        ToDo toDo = new ToDo(1L, "Zakupy", "Chleb");
        ToDo toDo1 = new ToDo(2L, "Remont", "kolanko");

        List<ToDo> toDos = new ArrayList<>();
        toDos.add(toDo);
        toDos.add(toDo1);

        when(todoService.findAll()).thenReturn(toDos);

        mockMvc.perform(get("/todosView"))
                .andExpect(status().isOk())
                .andExpect(view().name("todos"))
                .andExpect(model().attribute("list", hasSize(2)));
    }

}