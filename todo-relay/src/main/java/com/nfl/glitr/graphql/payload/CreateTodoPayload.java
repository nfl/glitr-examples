package com.nfl.glitr.graphql.payload;

import com.nfl.glitr.domain.Todo;
import com.nfl.glitr.registry.mutation.RelayMutationType;

public class CreateTodoPayload extends RelayMutationType {

    private Todo todo;

    public Todo getTodo() {
        return todo;
    }

    public CreateTodoPayload setTodo(Todo todo) {
        this.todo = todo;
        return this;
    }
}
