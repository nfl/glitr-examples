package com.nfl.glitr;

import com.nfl.glitr.controller.GraphQLController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestTodoRest {

    @Autowired
    private GraphQLController controller;

    @Test
    public void testQueryUser() {
        Map graphql = (Map) controller.graphql("query { user { id } }");
        LinkedHashMap user = (LinkedHashMap) graphql.get("user");
        assertTrue(user.get("id").equals("first-user"));
    }

    @Test
    public void testQueryTodo() {
        Map graphql = (Map) controller.graphql("query { todo { id text complete } }");
        LinkedHashMap todo = (LinkedHashMap) graphql.get("todo");
        assertTrue(todo.get("id") == "first-todo");
        assertTrue(todo.get("text") == null);
        assertTrue(todo.get("complete").equals(false));
    }

    @Test
    public void testMutationUser() {
        Map graphql = (Map) controller.graphql("mutation { createUser(input: { clientMutationId:\"test-user\" user: { id:\"new-user\" } }) { clientMutationId user { id } } }");
        LinkedHashMap createUser = (LinkedHashMap) graphql.get("createUser");
        assertTrue( createUser.get("clientMutationId").equals("test-user"));

        LinkedHashMap user = (LinkedHashMap) createUser.get("user");
        assertTrue( user.get("id").equals("new-user"));
    }

    @Test
    public void testMutationTodo() {
        Map graphql = (Map) controller.graphql("mutation { createTodo(input: { clientMutationId:\"test-todo\" todo: { id:\"new-todo\" text:\"new text\" complete:true } }) { clientMutationId todo { id text complete } } }");
        LinkedHashMap createTodo = (LinkedHashMap) graphql.get("createTodo");
        assertTrue(createTodo.get("clientMutationId").equals("test-todo"));

        LinkedHashMap todo = (LinkedHashMap) createTodo.get("todo");
        assertTrue(todo.get("id").equals("new-todo"));
        assertTrue(todo.get("text").equals("new text"));
        assertTrue(todo.get("complete").equals(true));
    }
}
