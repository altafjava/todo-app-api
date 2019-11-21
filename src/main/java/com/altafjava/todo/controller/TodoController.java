package com.altafjava.todo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.altafjava.todo.dto.Todo;
import com.altafjava.todo.service.TodoService;

@RestController
@RequestMapping("/users/{username}/todos")
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {

	@Autowired
	private TodoService todoService;

	@GetMapping
	public List<Todo> getAllTodos(@PathVariable String username) {
		return todoService.findAll();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable long id) {
		Todo todo = todoService.deleteById(id);
		if (todo != null)
			return ResponseEntity.noContent().build();
		return ResponseEntity.notFound().build();
	}
}
