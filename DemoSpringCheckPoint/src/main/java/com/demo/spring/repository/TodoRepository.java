package com.demo.spring.repository;

import com.demo.spring.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findByUserId(Long id);
    Optional<Todo> findByIdAndUserId(Long id, Long userId);
}
