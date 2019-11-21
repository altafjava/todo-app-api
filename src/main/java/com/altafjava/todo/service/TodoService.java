package com.altafjava.todo.service;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.altafjava.todo.dto.Todo;

@Service
public class TodoService {

	private static List<Todo> todos = new ArrayList<>();
	static long id = 0;
	static {
		todos.add(new Todo(++id, "Sam Altaf", "Learning Angular", new Date(), true));
		todos.add(new Todo(++id, "Ahmad Shah", "Playing Cricket", new Date(), false));
		todos.add(new Todo(++id, "Ankit Singh", "Teaching Java to their students", new Date(), false));
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

	private Todo findById(long id) {
		return todos.stream().filter(todo -> todo.getId() == id).findAny().orElse(null);
	}
}
