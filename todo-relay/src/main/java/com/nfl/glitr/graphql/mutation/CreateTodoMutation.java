package com.nfl.glitr.graphql.mutation;

import com.nfl.glitr.domain.Todo;
import com.nfl.glitr.domain.User;
import com.nfl.glitr.graphql.input.CreateTodoInput;
import com.nfl.glitr.graphql.payload.CreateTodoPayload;
import com.nfl.glitr.registry.mutation.RelayMutation;
import graphql.schema.DataFetchingEnvironment;

public class CreateTodoMutation implements RelayMutation<CreateTodoInput, CreateTodoPayload> {

    @Override
    public CreateTodoPayload call(CreateTodoInput input, DataFetchingEnvironment env) {
        Todo todo = new Todo()
                .setId(input.getId())
                .setText(input.getText())
                .setComplete(input.isComplete())
                .setUser(new User().setId(input.getUserId()));

        CreateTodoPayload payload = new CreateTodoPayload();
        payload.setTodo(todo);
        return payload;
    }
}
