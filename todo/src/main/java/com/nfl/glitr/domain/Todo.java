package com.nfl.glitr.domain;

import com.nfl.glitr.graphql.domain.graph.annotation.GlitrDescription;

@GlitrDescription("A Todo Object")
public class Todo {

    private String id;
    private String text;
    private boolean complete;

    public Todo(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public Todo setId(String id) {
        this.id = id;
        return this;
    }

    public String getText() {
        return text;
    }

    public Todo setText(String text) {
        this.text = text;
        return this;
    }

    public boolean isComplete() {
        return complete;
    }

    public Todo setComplete(boolean complete) {
        this.complete = complete;
        return this;
    }
}
