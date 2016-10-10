package com.nfl.glitr.graphql.input;

import com.nfl.glitr.domain.Todo;
import com.nfl.glitr.registry.mutation.RelayMutationType;

import java.util.List;

public class CreateUserInput extends RelayMutationType {

    private String id;
    private List<Todo> todoList;


    public String getId() {
        return id;
    }

    public CreateUserInput setId(String id) {
        this.id = id;
        return this;
    }

    public List<Todo> getTodoList() {
        return todoList;
    }

    public CreateUserInput setTodoList(List<Todo> todoList) {
        this.todoList = todoList;
        return this;
    }
}
