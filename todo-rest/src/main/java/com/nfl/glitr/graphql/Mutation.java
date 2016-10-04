package com.nfl.glitr.graphql;

import com.nfl.glitr.domain.Todo;
import com.nfl.glitr.domain.User;
import com.nfl.glitr.graphql.input.CreateTodoInput;
import com.nfl.glitr.graphql.input.CreateUserInput;
import com.nfl.dm.shield.graphql.domain.graph.annotation.GlitrArgument;
import com.nfl.dm.shield.graphql.domain.graph.annotation.GlitrDescription;
import com.nfl.dm.shield.util.JsonUtils;
import com.nfl.glitr.graphql.payload.CreateTodoPayload;
import com.nfl.glitr.graphql.payload.CreateUserPayload;
import graphql.schema.DataFetchingEnvironment;

import java.util.Map;

@GlitrDescription("Where to persist something.")
public class Mutation {

    @GlitrArgument(name = "input", type = CreateUserInput.class, nullable = false)
    public CreateUserPayload getCreateUser(DataFetchingEnvironment env) {
        Map inputMap = env.getArgument("input");
        CreateUserInput input = JsonUtils.convertValue(inputMap, CreateUserInput.class);

        User user = new User(input.getUser().getId());
        CreateUserPayload payload = new CreateUserPayload();
        payload.setUser(user);
        payload.setClientMutationId(input.getClientMutationId());

        return payload;
    }

    @GlitrArgument(name = "input", type = CreateTodoInput.class, nullable = false)
    public CreateTodoPayload getCreateTodo(DataFetchingEnvironment env) {
        Map inputMap = env.getArgument("input");
        CreateTodoInput input = JsonUtils.convertValue(inputMap, CreateTodoInput.class);

        Todo todo = new Todo(input.getTodo().getId())
                .setText(input.getTodo().getText())
                .setComplete(input.getTodo().isComplete());
        CreateTodoPayload payload = new CreateTodoPayload();
        payload.setTodo(todo);
        payload.setClientMutationId(input.getClientMutationId());

        return payload;

    }
}
