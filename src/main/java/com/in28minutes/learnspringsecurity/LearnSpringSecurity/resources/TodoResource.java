package com.in28minutes.learnspringsecurity.LearnSpringSecurity.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoResource {

    private static final List<Todo> TODOS_LIST = List.of(new Todo("Ahmed", "Learn aws"), new Todo("Aymen", "Learn Devops"));

    private Logger logger = LoggerFactory.getLogger(getClass());
    @GetMapping("/todos")
    public List<Todo> retrieveAllTodos() {
        return TODOS_LIST;
    }

    @GetMapping("/users/{username}/todos")
    public Todo retrieveTodosForSpecificUser(@PathVariable String username) {
        return TODOS_LIST.get(0);
    }

    @PostMapping("/users/{username}/todos")
    public void createTodoForSpecificUser(@PathVariable String username, @RequestBody Todo todo) {
        logger.info("Creating {} for {}", todo, username);

    }

}

record Todo(String username, String description) {
}
