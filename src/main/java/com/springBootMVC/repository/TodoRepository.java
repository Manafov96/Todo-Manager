package com.springBootMVC.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springBootMVC.models.Todos;

public interface TodoRepository extends JpaRepository<Todos, Long> {

}
