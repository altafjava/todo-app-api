package com.altafjava.todo.controller;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

	@GetMapping("/{id}")
	public Todo getTodo(@PathVariable long id) {
		return todoService.findById(id);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable long id) {
		Todo todo = todoService.deleteById(id);
		if (todo != null)
			return ResponseEntity.noContent().build();
		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable long id,
			@RequestBody Todo todo) {
		Todo updatedTodo = todoService.save(todo);
		return new ResponseEntity<Todo>(updatedTodo, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Void> updateTodo(@PathVariable String username, @RequestBody Todo todo) {
		Todo updatedTodo = todoService.save(todo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(updatedTodo.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
