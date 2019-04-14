package com.romanstetsiuk.spring_tdd.service;

import com.romanstetsiuk.spring_tdd.model.ToDo;

import java.util.List;
import java.util.Optional;

public interface TodoService {

    List<ToDo> findAll();

    Optional<ToDo> findById(Long id);

}
