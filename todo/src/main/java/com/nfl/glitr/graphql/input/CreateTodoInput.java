package com.nfl.glitr.graphql.input;

public class CreateTodoInput {

    private String id;
    private String text;
    private boolean complete;
    private String userId;


    public String getId() {
        return id;
    }

    public CreateTodoInput setId(String id) {
        this.id = id;
        return this;
    }

    public String getText() {
        return text;
    }

    public CreateTodoInput setText(String text) {
        this.text = text;
        return this;
    }

    public boolean isComplete() {
        return complete;
    }

    public CreateTodoInput setComplete(boolean complete) {
        this.complete = complete;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public CreateTodoInput setUserId(String userId) {
        this.userId = userId;
        return this;
    }
}
