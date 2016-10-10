package com.nfl.glitr.graphql.mutation;

import com.nfl.glitr.domain.User;
import com.nfl.glitr.graphql.input.CreateUserInput;
import com.nfl.glitr.graphql.payload.CreateUserPayload;
import com.nfl.glitr.registry.mutation.RelayMutation;
import graphql.schema.DataFetchingEnvironment;

public class CreateUserMutation implements RelayMutation<CreateUserInput, CreateUserPayload> {

    @Override
    public CreateUserPayload call(CreateUserInput input, DataFetchingEnvironment env) {
        // would save user in a store and return saved element
        User user = new User()
                .setId(input.getId())
                .setTodoList(input.getTodoList());

        CreateUserPayload payload = new CreateUserPayload();
        payload.setUser(user);
        return payload;
    }
}
