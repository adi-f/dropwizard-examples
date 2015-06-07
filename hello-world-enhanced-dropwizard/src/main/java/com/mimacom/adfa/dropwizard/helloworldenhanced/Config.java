package com.mimacom.adfa.dropwizard.helloworldenhanced;

import java.net.URI;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import io.dropwizard.Configuration;


public class Config extends Configuration {

    @Valid
    @NotNull
    private String greeting = "Hello %s!";

    @Valid
    @NotNull
    private URI helloEndpoint = URI.create("http//localhost:8080/say-hello");

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public URI getHelloEndpoint() {
        return helloEndpoint;
    }

    public void setHelloEndpoint(URI helloEndpoint) {
        this.helloEndpoint = helloEndpoint;
    }
}
