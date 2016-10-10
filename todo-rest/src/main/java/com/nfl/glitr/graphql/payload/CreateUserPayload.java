package com.nfl.glitr.graphql.payload;

import com.nfl.glitr.domain.User;
import com.nfl.glitr.registry.mutation.RelayMutationType;

public class CreateUserPayload extends RelayMutationType {

    private User user;

    public User getUser() {
        return user;
    }

    public CreateUserPayload setUser(User user) {
        this.user = user;
        return this;
    }
}
