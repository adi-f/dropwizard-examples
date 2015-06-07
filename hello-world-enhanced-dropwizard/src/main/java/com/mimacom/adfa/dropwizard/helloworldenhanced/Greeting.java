package com.mimacom.adfa.dropwizard.helloworldenhanced;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Greeting {

    private final String greeting, name;

    @JsonCreator
    public Greeting(@JsonProperty("greeting") String greeting, @JsonProperty("name") String name) {
        this.greeting = greeting;
        this.name = name;
    }

    public String getGreeting() {
        return greeting;
    }

    public String getName() {
        return name;
    }
}
