package com.nfl.glitr.graphql.input;

public class CreateUserInput {

    private UserMutation userMutation;

    public UserMutation getUser() {
        return userMutation;
    }

    public CreateUserInput setUser(UserMutation userMutation) {
        this.userMutation = userMutation;
        return this;
    }

    public static class UserMutation {

        private String id;

        public String getId() {
            return id;
        }

        public UserMutation setId(String id) {
            this.id = id;
            return this;
        }
    }
}
