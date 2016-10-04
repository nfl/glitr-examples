package com.nfl.glitr.graphql;

import com.nfl.dm.shield.graphql.domain.graph.annotation.GlitrDescription;
import com.nfl.glitr.domain.Todo;
import com.nfl.glitr.domain.User;
import graphql.schema.DataFetchingEnvironment;

@GlitrDescription("Where it all begins.")
public class Root {

    public Todo getTodo(DataFetchingEnvironment env) {
        return new Todo("first-todo");
    }

    public User getUser(DataFetchingEnvironment env) {
        return new User("first-user");
    }
}
