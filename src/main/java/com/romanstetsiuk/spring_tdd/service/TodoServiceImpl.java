package com.romanstetsiuk.spring_tdd.service;

import com.romanstetsiuk.spring_tdd.model.ToDo;
import com.romanstetsiuk.spring_tdd.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    TodoRepository todoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<ToDo> findAll() {
        return todoRepository.findAll();
    }
}
