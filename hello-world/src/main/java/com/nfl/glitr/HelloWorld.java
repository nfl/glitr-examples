package com.nfl.glitr;

import com.nfl.glitr.annotation.GlitrDescription;
import graphql.GraphQL;
import graphql.schema.DataFetchingEnvironment;

import java.util.Map;

public class HelloWorld {

    public static void main(String[] args) {
        Glitr glitr = GlitrBuilder.newGlitr()
                .withQueryRoot(new Root())
                .build();

        GraphQL graphQL = new GraphQL(glitr.getSchema());
        Map<String, Object> result = (Map<String, Object>) graphQL.execute("{hello}").getData();

        System.out.println(result); // prints: {hello=World!}
    }

    @GlitrDescription("Where it all begins.")
    public static class Root {
        public String getHello(DataFetchingEnvironment environment) {
            return "World!";
        }
    }
}
