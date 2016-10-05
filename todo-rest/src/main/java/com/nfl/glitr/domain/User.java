package com.nfl.glitr.domain;

import com.nfl.glitr.graphql.domain.graph.annotation.GlitrDescription;

@GlitrDescription("A User Object")
public class User {

    private String id;

    public User(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public User setId(String id) {
        this.id = id;
        return this;
    }
}
