package com.mimacom.adfa.dropwizard.helloworld;

import io.dropwizard.Configuration;

public class Config extends Configuration {

    private String greeting = "Hello %s!";

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
