package com.nfl.glitr;

import com.nfl.glitr.graphql.Mutation;
import com.nfl.glitr.graphql.Root;
import graphql.GraphQL;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class TestTodo {

    private static GraphQL graphQL;

    @BeforeClass
    public static void init() {
        Glitr glitr = GlitrBuilder.newGlitr()
                .withQueryRoot(new Root())
                .withMutationRoot(new Mutation())
                .build();
        graphQL = new GraphQL(glitr.getSchema());
    }

    @Test
    public void testQueryUser() {
        Map result = (Map) graphQL.execute("query { user { id } }").getData();
        LinkedHashMap user = (LinkedHashMap) result.get("user");
        assertTrue(user.get("id") == "first-user");
    }

    @Test
    public void testQueryTodo() {
        Map result = (Map) graphQL.execute("query { todo { id text complete } }").getData();
        LinkedHashMap todo = (LinkedHashMap) result.get("todo");
        assertTrue(todo.get("id") == "first-todo");
        assertTrue(todo.get("text") == null);
        assertTrue(todo.get("complete").equals(false));
    }

    @Test
    public void testMutationUser() {
        Map result = (Map) graphQL.execute("mutation { createUser(input: { id:\"new-user\" }) { id } }").getData();
        LinkedHashMap user = (LinkedHashMap) result.get("createUser");
        assertTrue(user.get("id").equals("new-user"));
    }

    @Test
    public void testMutationTodo() {
        Map result = (Map) graphQL.execute("mutation { createTodo(input: { id:\"new-todo\" text:\"new text\" complete:true }) { id text complete } }").getData();
        LinkedHashMap todo = (LinkedHashMap) result.get("createTodo");
        assertTrue(todo.get("id").equals("new-todo"));
        assertTrue(todo.get("text").equals("new text"));
        assertTrue(todo.get("complete").equals(true));
    }
}
