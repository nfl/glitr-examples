package com.nfl.glitr.graphql;

import com.nfl.glitr.annotation.GlitrArgument;
import com.nfl.glitr.annotation.GlitrDescription;
import com.nfl.glitr.graphql.input.CreateTodoInput;
import com.nfl.glitr.graphql.input.CreateUserInput;
import com.nfl.glitr.graphql.mutation.CreateTodoMutation;
import com.nfl.glitr.graphql.mutation.CreateUserMutation;
import com.nfl.glitr.graphql.payload.CreateTodoPayload;
import com.nfl.glitr.graphql.payload.CreateUserPayload;
import com.nfl.glitr.registry.mutation.RelayMutationDataFetcher;
import graphql.schema.DataFetchingEnvironment;

@GlitrDescription("Where to persist something.")
public class Mutation {

    @GlitrArgument(name = "input", type = CreateUserInput.class, nullable = false)
    public CreateUserPayload getCreateUser(DataFetchingEnvironment env) {
        RelayMutationDataFetcher mutationDataFetcher = new RelayMutationDataFetcher(CreateUserInput.class, new CreateUserMutation());
        return (CreateUserPayload) mutationDataFetcher.get(env);
    }

    @GlitrArgument(name = "input", type = CreateTodoInput.class, nullable = false)
    public CreateTodoPayload getCreateTodo(DataFetchingEnvironment env) {
        RelayMutationDataFetcher mutationDataFetcher = new RelayMutationDataFetcher(CreateTodoInput.class, new CreateTodoMutation());
        return (CreateTodoPayload) mutationDataFetcher.get(env);
    }
}
