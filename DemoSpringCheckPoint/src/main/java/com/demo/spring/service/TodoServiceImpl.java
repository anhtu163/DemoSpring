package com.demo.spring.service;

import com.demo.spring.model.Todo;
import com.demo.spring.model.User;
import com.demo.spring.repository.TodoRepository;
import com.demo.spring.repository.UserRepository;
import com.demo.spring.security.service.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements com.demo.spring.service.TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Todo> todoListByUserId(Long userId) {
        return todoRepository.findByUserId(userId);
    }

    @Override
    public Optional<Todo> findById(Long todoId, Long userId) {
        return todoRepository.findByIdAndUserId(todoId, userId);
    }

    @Override
    public Todo save(CustomUserDetails currentUser, Todo todo) {
        Optional<User> user = userRepository.findById(currentUser.getId());
        if (user.isPresent()) {
            todo.setUser(user.get());
        }
        return todoRepository.save(todo);
    }

    @Override
    public void delete(Todo todo) {
        todoRepository.delete(todo);
    }

}
