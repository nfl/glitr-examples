package com.nfl.glitr.graphql;

import com.nfl.glitr.annotation.GlitrArgument;
import com.nfl.glitr.annotation.GlitrDescription;
import com.nfl.glitr.domain.Todo;
import com.nfl.glitr.domain.User;
import com.nfl.glitr.graphql.input.CreateTodoInput;
import com.nfl.glitr.graphql.input.CreateUserInput;
import com.nfl.glitr.util.JsonUtils;
import graphql.schema.DataFetchingEnvironment;

import java.util.Map;

@GlitrDescription("Where to persist something.")
public class Mutation {

    @GlitrArgument(name = "input", type = CreateUserInput.class, nullable = false)
    public User getCreateUser(DataFetchingEnvironment env) {
        Map inputMap = env.getArgument("input");
        CreateUserInput input = JsonUtils.convertValue(inputMap, CreateUserInput.class);
        return new User()
                .setId(input.getId())
                .setTodoList(input.getTodoList());
    }

    @GlitrArgument(name = "input", type = CreateTodoInput.class, nullable = false)
    public Todo getCreateTodo(DataFetchingEnvironment env) {
        Map inputMap = env.getArgument("input");
        CreateTodoInput input = JsonUtils.convertValue(inputMap, CreateTodoInput.class);
        return new Todo()
                .setId(input.getId())
                .setText(input.getText())
                .setComplete(input.isComplete());
    }
}
