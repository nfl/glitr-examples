package com.nfl.glitr.config;

import com.nfl.glitr.graphql.Glitr;
import com.nfl.glitr.graphql.GlitrBuilder;
import com.nfl.glitr.graphql.Mutation;
import com.nfl.glitr.graphql.Root;
import graphql.GraphQL;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GlitrConfiguration {

    @Bean
    public Glitr glitr() {
        return GlitrBuilder.newGlitr()
                .withQueryRoot(new Root())
                .withMutationRoot(new Mutation())
                .build();
    }

    @Bean
    public GraphQL graphQL(Glitr glitr) {
        return new GraphQL(glitr.getSchema());
    }
}
