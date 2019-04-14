package com.romanstetsiuk.spring_tdd.service;

import com.romanstetsiuk.spring_tdd.model.ToDo;

import java.util.List;

public interface TodoService {

    List<ToDo> findAll();

}
