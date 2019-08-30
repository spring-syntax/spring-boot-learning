package com.bytechnology.springfirststeps.services;

import com.bytechnology.springfirststeps.model.Todo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ToDoService {
    private static List<Todo> todos = new ArrayList<>();
    private static int todoCount = 3;

    static {
        todos.add(new Todo(1, "Dorin", "Learn Spring", LocalDate.now(),false));
        todos.add(new Todo(2, "Dorin", "Learn Spring Boot", LocalDate.now(), false));
        todos.add(new Todo(3, "in28minutes", "Learn Microservices", LocalDate.now(),false));
    }

    public List<Todo> retrieveToDos(String user) {
        return todos.stream().filter(todo -> todo.getUser().equalsIgnoreCase(user)).collect(Collectors.toList());
    }

    public void addTodo(String name, String desc, LocalDate targetDate,boolean isDone) {
        todos.add(new Todo(++todoCount, name, desc, targetDate, isDone));
    }

    public void deleteTodo(int id) {
        todos.removeIf(todo -> todo.getId() == id);
    }
}