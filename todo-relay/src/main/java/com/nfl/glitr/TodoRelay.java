package com.nfl.glitr;

import com.nfl.glitr.domain.User;
import com.nfl.glitr.domain.UserOverrideDataFetcher;
import com.nfl.glitr.graphql.Mutation;
import com.nfl.glitr.graphql.Root;
import com.nfl.glitr.util.ObjectMapper;
import graphql.GraphQL;

public class TodoRelay {

    public static void main(String[] args) {
        Glitr glitr = GlitrBuilder.newGlitr()
                .withQueryRoot(new Root())
                .withMutationRoot(new Mutation())
                .addOverride(User.class, new UserOverrideDataFetcher())
                .withObjectMapper(configureGlitrObjectMapper())
                .build();

        GraphQL graphQL = new GraphQL(glitr.getSchema());

        System.out.println(graphQL.execute("query { todo { id text complete } }").getData());
        System.out.println(graphQL.execute("query { user { id todoList(first:2) { edges { node { id } } } } }").getData());
        System.out.println(graphQL.execute("mutation { createUser(input: { clientMutationId:\"test-user\" id:\"new-user\" }) { clientMutationId user { id } } }").getData());
        System.out.println(graphQL.execute("mutation { createTodo(input: { clientMutationId:\"test-todo\" id:\"new-todo\" text:\"new text\" complete:true }) { clientMutationId todo { id text complete } } }").getData());
    }

    /**
     * Jackson implementation of the GLiTR ObjectMapper
     * @return ObjectMapper
     */
    public static ObjectMapper configureGlitrObjectMapper() {
        return new ObjectMapper() {

            private com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
            @Override
            public <T> T convertValue(Object o, Class<T> aClass) {
                return objectMapper.convertValue(o, aClass);
            }
        };
    }
}
