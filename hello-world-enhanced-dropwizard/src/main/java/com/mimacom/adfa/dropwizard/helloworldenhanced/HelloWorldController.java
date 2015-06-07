package com.mimacom.adfa.dropwizard.helloworldenhanced;

import java.net.URI;
import java.net.URL;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang3.StringUtils;

@Path("/")
public class HelloWorldController {

    private final String greeting;
    private final Client client;
    private final URI helloEndpoint;


    public HelloWorldController(String greeting, URI helloEndpoint, Client client) {
        this.greeting = greeting;
        this.client = client;
        this.helloEndpoint = helloEndpoint;
    }

    @GET
    @Path("say-hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String sayPlainHello(@QueryParam("name") String name) {

        Greeting  greeting = client
            .target(helloEndpoint)
            .queryParam("name", name)
            .request()
            .accept(MediaType.APPLICATION_JSON)
            .get(Greeting.class);
        String plainGreeting = String.format(greeting.getGreeting(), greeting.getName());

        return plainGreeting;
    }

    @GET
    @Path("say-hello")
    @Produces(MediaType.APPLICATION_JSON)
    public Greeting sayStructHello(@QueryParam("name") String name) {
        return new Greeting(greeting, name);
    }

}
