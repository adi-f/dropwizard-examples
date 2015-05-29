package com.mimacom.adfa.dropwizard.helloworld;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import io.dropwizard.Configuration;


public class Config extends Configuration {

    @Valid
    @NotNull
    private String greeting = "Hello %s!";

    @Valid
    @NotNull
    private String defaultName = "World";

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public String getDefaultName() {
        return defaultName;
    }

    public void setDefaultName(String defaultName) {
        this.defaultName = defaultName;
    }
}
