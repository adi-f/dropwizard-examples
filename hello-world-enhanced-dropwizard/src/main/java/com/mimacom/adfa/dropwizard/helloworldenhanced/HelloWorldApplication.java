package com.mimacom.adfa.dropwizard.helloworldenhanced;

import javax.ws.rs.client.Client;

import io.dropwizard.Application;
import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.setup.Environment;

public class HelloWorldApplication extends Application<Config>{

    public static void main(String[] args) throws Exception {
        new HelloWorldApplication().run(args);
    }

    @Override
    public void run(Config configuration, Environment environment) throws Exception {
        Client client = new JerseyClientBuilder(environment).build(getName());
        environment.jersey().register(new HelloWorldController(
            configuration.getGreeting(),
            configuration.getHelloEndpoint(),
            client));
    }
}
