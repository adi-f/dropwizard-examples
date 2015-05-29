package com.mimacom.adfa.dropwizard.helloworld;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang3.StringUtils;

@Path("/")
public class HelloWorldController {

    private final String greeting;
    private final String defaultName;


    public HelloWorldController(String greeting, String defaultName) {
        this.greeting = greeting;
        this.defaultName = defaultName;
    }

    @GET
    @Path("say-hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello(@QueryParam("name") String name) {
        name = StringUtils.defaultString(name, "World");
        return String.format(greeting, name);
    }
}
