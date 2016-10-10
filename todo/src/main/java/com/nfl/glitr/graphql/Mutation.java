package com.nfl.glitr.graphql;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nfl.glitr.annotation.GlitrArgument;
import com.nfl.glitr.annotation.GlitrDescription;
import com.nfl.glitr.domain.Todo;
import com.nfl.glitr.domain.User;
import com.nfl.glitr.graphql.input.CreateTodoInput;
import com.nfl.glitr.graphql.input.CreateUserInput;
import graphql.schema.DataFetchingEnvironment;

import java.util.Map;

@GlitrDescription("Where to persist something.")
public class Mutation {

    private static ObjectMapper objectMapper = new ObjectMapper();

    @GlitrArgument(name = "input", type = CreateUserInput.class, nullable = false)
    public User getCreateUser(DataFetchingEnvironment env) {
        Map inputMap = env.getArgument("input");
        CreateUserInput input = objectMapper.convertValue(inputMap, CreateUserInput.class);

        return new User()
                .setId(input.getId())
                .setTodoList(input.getTodoList());
    }

    @GlitrArgument(name = "input", type = CreateTodoInput.class, nullable = false)
    public Todo getCreateTodo(DataFetchingEnvironment env) {
        Map inputMap = env.getArgument("input");
        CreateTodoInput input = objectMapper.convertValue(inputMap, CreateTodoInput.class);

        return new Todo()
                .setId(input.getId())
                .setText(input.getText())
                .setComplete(input.isComplete())
                .setUser(new User().setId(input.getUserId()));
    }
}