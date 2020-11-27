package com.demo.spring.service;

import com.demo.spring.model.Todo;
import com.demo.spring.security.service.CustomUserDetails;

import java.util.List;
import java.util.Optional;

public interface TodoService {
	
	List<Todo> todoListByUserId(Long userId);

	Optional<Todo> findById(Long todoId,Long userId);

	Todo save(CustomUserDetails currentUser, Todo todo);

	void delete(Todo todo);

}
