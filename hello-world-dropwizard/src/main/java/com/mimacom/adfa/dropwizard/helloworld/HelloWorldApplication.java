package com.mimacom.adfa.dropwizard.helloworld;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class HelloWorldApplication extends Application<Config>{

    public static void main(String[] args) throws Exception {
        new HelloWorldApplication().run(args);
    }

    @Override
    public void run(Config configuration, Environment environment) throws Exception {
        environment.jersey().register(new HelloWorldController(
            configuration.getGreeting(),
            configuration.getDefaultName()
        ));
    }
}
