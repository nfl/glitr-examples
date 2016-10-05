package com.nfl.glitr.graphql.payload;

import com.nfl.glitr.graphql.registry.mutation.RelayMutationType;
import com.nfl.glitr.domain.Todo;

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
