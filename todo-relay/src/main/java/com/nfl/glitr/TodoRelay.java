package com.nfl.glitr;

import com.nfl.glitr.domain.User;
import com.nfl.glitr.domain.UserOverrideDataFetcher;
import com.nfl.glitr.graphql.Glitr;
import com.nfl.glitr.graphql.GlitrBuilder;
import com.nfl.glitr.graphql.Mutation;
import com.nfl.glitr.graphql.Root;
import graphql.GraphQL;

public class TodoRelay {

    public static void main(String[] args) {
        Glitr glitr = GlitrBuilder.newGlitrWithRelaySupport()
                .withQueryRoot(new Root())
                .withMutationRoot(new Mutation())
                .addOverride(User.class, new UserOverrideDataFetcher())
                .build();

        GraphQL graphQL = new GraphQL(glitr.getSchema());

        System.out.println(graphQL.execute("query { todo { id text complete } }").getData());
        System.out.println(graphQL.execute("query { user { id todoList(first:2) { edges { node { id } } } } }").getData());
        System.out.println(graphQL.execute("mutation { createUser(input: { clientMutationId:\"test-user\" id:\"new-user\" }) { clientMutationId user { id } } }").getData());
        System.out.println(graphQL.execute("mutation { createTodo(input: { clientMutationId:\"test-todo\" id:\"new-todo\" text:\"new text\" complete:true }) { clientMutationId todo { id text complete } } }").getData());
    }
}
