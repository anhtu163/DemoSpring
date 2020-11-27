package com.demo.spring.controller;

import com.demo.spring.model.Todo;
import com.demo.spring.repository.TodoRepository;
import com.demo.spring.security.CurrentUser;
import com.demo.spring.security.service.CustomUserDetails;
import com.demo.spring.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

@RestController
public class TodoListController {
    @Autowired
    private TodoService todoService;

    private void logger(String log) {
        System.out.println(new Date() + log);
    }

    /**
     * HTTP GET
     */
    @RequestMapping(value = "/api/todolist/{index}",
            method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getTodoItem(@CurrentUser CustomUserDetails currentUser, @PathVariable("index") Long index) {
        logger(new Date() + " GET ======= /api/todolist/{" + index
                + "} =======");
        try {
            return new ResponseEntity<>(todoService.findById(index, currentUser.getId()).get(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(index + " not found", HttpStatus.NOT_FOUND);
        }
    }

    /**
     * HTTP GET ALL
     */
    @RequestMapping(value = "/api/todolist", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getAllTodoItems(@CurrentUser CustomUserDetails currentUser) {
        logger(new Date() + " GET ======= /api/todolist =======");
        try {
            return new ResponseEntity<>(todoService.todoListByUserId(currentUser.getId()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Nothing found", HttpStatus.NOT_FOUND);
        }
    }

    /**
     * HTTP POST NEW ONE
     */
    @RequestMapping(value = "/api/todolist", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addNewTodoItem(@CurrentUser CustomUserDetails currentUser, @Valid @RequestBody Todo item) {
        logger(new Date() + " POST ======= /api/todolist ======= " + item);
        try {
            todoService.save(currentUser, item);
            return new ResponseEntity<String>("Entity created", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<String>("Entity creation failed" + e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    /**
     * HTTP PUT UPDATE
     */
    @RequestMapping(value = "/api/todolist", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateTodoItem(@CurrentUser CustomUserDetails currentUser, @RequestBody Todo item) {
        logger(new Date() + " PUT ======= /api/todolist ======= " + item);
        try {
            todoService.save(currentUser, item);
            return new ResponseEntity<String>("Entity updated", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("Entity updating failed", HttpStatus.NOT_FOUND);
        }
    }

    /**
     * HTTP DELETE
     */
    @RequestMapping(value = "/api/todolist/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteTodoItem(@CurrentUser CustomUserDetails currentUser, @PathVariable("id") Long id) {
        logger(new Date() + " DELETE ======= /api/todolist/{" + id
                + "} ======= ");
        try {
            Todo todo = todoService.findById(id, currentUser.getId()).get();
            todoService.delete(todo);
            return new ResponseEntity<String>("Entity deleted", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("Entity deletion failed", HttpStatus.NOT_FOUND);
        }

    }
}
