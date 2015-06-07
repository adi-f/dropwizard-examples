package com.mimacom.adfa.jee.helloworld;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang3.StringUtils;

@Path("/")
public class HelloWorldController {

    private String greeting = System.getProperty("greeting", "Hello %s!");
    private String defaultName = System.getProperty("defaultName", "World");

    @GET
    @Path("say-hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello(@QueryParam("name") String name) {
        name = StringUtils.defaultString(name, defaultName);
        return String.format(greeting, name);
    }
}
