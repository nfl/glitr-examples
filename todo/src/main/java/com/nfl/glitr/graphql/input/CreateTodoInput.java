package com.nfl.glitr.graphql.input;

public class CreateTodoInput {

    private TodoMutation todoMutation;

    public TodoMutation getTodo() {
        return todoMutation;
    }

    public CreateTodoInput setTodo(TodoMutation todoMutation) {
        this.todoMutation = todoMutation;
        return this;
    }

    public static class TodoMutation {

        private String id;
        private String text;
        private boolean complete;

        public String getId() {
            return id;
        }

        public TodoMutation setId(String id) {
            this.id = id;
            return this;
        }

        public String getText() {
            return text;
        }

        public TodoMutation setText(String text) {
            this.text = text;
            return this;
        }

        public boolean isComplete() {
            return complete;
        }

        public TodoMutation setComplete(boolean complete) {
            this.complete = complete;
            return this;
        }
    }
}
