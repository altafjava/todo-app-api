package com.altafjava.todo.service;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.altafjava.todo.dto.Todo;

@Service
public class TodoService {

	private static List<Todo> todos = new ArrayList<>();
	static long idCounter = 0;
	static {
		todos.add(new Todo(++idCounter, "Sam Altaf", "Learning Angular", new Date(), true));
		todos.add(new Todo(++idCounter, "Ahmad Shah", "Playing Cricket", new Date(), false));
		todos.add(new Todo(++idCounter, "Ankit Singh", "Teaching Java to their students", new Date(), false));
	}

	public List<Todo> findAll() {
		return todos;
	}

	public Todo deleteById(long id) {
		Todo todo = findById(id);
		if (todo == null)
			return null;
		if (todos.remove(todo))
			return todo;
		else
			return null;
	}

	public Todo findById(long id) {
		return todos.stream().filter(todo -> todo.getId() == id).findAny().orElse(null);
	}

	public Todo save(Todo todo) {
		long id = todo.getId();
		if (id == 0) {
			todo.setId(++idCounter);
			todos.add(todo);
		} else {
			deleteById(id);
			todos.add(todo);
		}
		return todo;
	}
}
