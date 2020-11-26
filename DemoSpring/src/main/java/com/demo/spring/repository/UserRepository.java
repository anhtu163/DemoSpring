package com.demo.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.spring.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	public User findByUsername(String username);
}
