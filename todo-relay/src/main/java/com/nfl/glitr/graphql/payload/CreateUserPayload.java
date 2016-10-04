package com.nfl.glitr.graphql.payload;

import com.nfl.dm.shield.graphql.registry.mutation.RelayMutationType;
import com.nfl.glitr.domain.User;

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
