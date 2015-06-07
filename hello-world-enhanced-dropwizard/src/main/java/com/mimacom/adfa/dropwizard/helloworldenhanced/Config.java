package com.mimacom.adfa.dropwizard.helloworldenhanced;

import java.net.URI;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import io.dropwizard.Configuration;
import io.dropwizard.client.JerseyClientConfiguration;

public class Config extends Configuration {

    @Valid
    @NotNull
    private String greeting;

    @Valid
    @NotNull
    private URI helloEndpoint;

    private final JerseyClientConfiguration client = new JerseyClientConfiguration();

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

    public JerseyClientConfiguration getClient() {
        return client;
    }
}
