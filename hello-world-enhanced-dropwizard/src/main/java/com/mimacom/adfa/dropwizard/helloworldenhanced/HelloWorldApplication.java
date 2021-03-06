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

        Client client = new JerseyClientBuilder(environment).using(configuration.getClient()).build(getName());

        HelloWorldController helloWorldController = new HelloWorldController(
            configuration.getGreeting(),
            configuration.getHelloEndpoint(),
            client);

        environment.jersey().register(helloWorldController);

        environment.healthChecks().register(helloWorldController.getClass().getSimpleName(), helloWorldController);
    }
}
