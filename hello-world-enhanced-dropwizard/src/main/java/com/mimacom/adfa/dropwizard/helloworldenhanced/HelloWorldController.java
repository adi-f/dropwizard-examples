package com.mimacom.adfa.dropwizard.helloworldenhanced;

import java.net.URI;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codahale.metrics.health.HealthCheck;


@Path("/")
public class HelloWorldController extends HealthCheck {

    private static final Logger LOG = LoggerFactory.getLogger(HelloWorldController.class);

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

        LOG.info("Plain greeting with name: {}", name);

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
        LOG.info("Json greeting with name: {}", name);
        return new Greeting(greeting, name);
    }

    @Override
    protected Result check() throws Exception {
        try {
            if(StringUtils.isNotEmpty(sayPlainHello("HEALTH CHECK"))){
                return Result.healthy();
            }
        } catch (Exception e) {
            LOG.error("The health check threw an exception!", e);
        }
        return Result.unhealthy("unexpected say hello");
    }
}
