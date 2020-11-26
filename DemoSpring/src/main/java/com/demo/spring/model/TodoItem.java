package com.demo.spring.model;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Value;

import lombok.Data;

@Entity
@Data
@Table(name="todo_item")
public class TodoItem {

	@Id
	@GeneratedValue
	private int id;
	
	private String content;
	
	private int finished;
	
	@
	private User user;
}
