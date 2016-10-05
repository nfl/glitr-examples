package com.nfl.glitr.graphql.input;

import com.nfl.glitr.graphql.registry.mutation.RelayMutationType;

public class CreateUserInput extends RelayMutationType {

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
