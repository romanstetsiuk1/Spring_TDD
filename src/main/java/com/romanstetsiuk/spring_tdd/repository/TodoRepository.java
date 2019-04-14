package com.romanstetsiuk.spring_tdd.repository;

import com.romanstetsiuk.spring_tdd.model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<ToDo, Long> {



}
