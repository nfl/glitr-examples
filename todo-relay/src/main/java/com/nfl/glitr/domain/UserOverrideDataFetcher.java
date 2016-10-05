package com.nfl.glitr.domain;

import graphql.relay.Connection;
import graphql.relay.SimpleListConnection;
import graphql.schema.DataFetchingEnvironment;

public class UserOverrideDataFetcher {

    public Connection getTodoList(DataFetchingEnvironment env) {
        User user = (User) env.getSource();
        return (Connection) new SimpleListConnection(user.getTodoList()).get(env);
    }
}
