package com.altafjava.todo.service;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.altafjava.todo.dto.Todo;

@Service
public class TodoService {

	public List<Todo> findAll() {
		List<Todo> todos = new ArrayList<>();
		long id = 0;
		todos.add(new Todo(++id, "Sam Altaf", "Learning Angular", new Date(), true));
		todos.add(new Todo(++id, "Ahmad Shah", "Playing Cricket", new Date(), false));
		todos.add(new Todo(++id, "Ankit Singh", "Teaching Java to their students", new Date(), false));
		return todos;
	}
}
