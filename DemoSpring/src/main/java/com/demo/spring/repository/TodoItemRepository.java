package com.demo.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.spring.model.TodoItem;

public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {

}
