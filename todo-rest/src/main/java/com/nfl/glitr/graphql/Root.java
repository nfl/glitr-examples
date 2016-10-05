package com.nfl.glitr.graphql;

import com.nfl.glitr.graphql.domain.graph.annotation.GlitrDescription;
import com.nfl.glitr.domain.Todo;
import com.nfl.glitr.domain.User;
import graphql.schema.DataFetchingEnvironment;

@GlitrDescription("Where it all begins.")
public class Root {

    public Todo getTodo(DataFetchingEnvironment env) {
        return new Todo().setId("first-todo");
    }

    public User getUser(DataFetchingEnvironment env) {
        return new User().setId("first-user");
    }
}
