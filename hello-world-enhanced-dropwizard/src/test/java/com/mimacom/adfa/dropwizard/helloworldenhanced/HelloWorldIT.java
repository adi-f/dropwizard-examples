package com.mimacom.adfa.dropwizard.helloworldenhanced;

import static org.junit.Assert.assertEquals;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.ClassRule;
import org.junit.Test;

import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.testing.ResourceHelpers;
import io.dropwizard.testing.junit.DropwizardAppRule;

public class HelloWorldIT {

    @ClassRule
    public static final DropwizardAppRule<Config> application =
        new DropwizardAppRule<>(
            HelloWorldApplication.class,
            ResourceHelpers.resourceFilePath("test-configuration.yaml"));

    @Test
    public void testSayPlainHello() {
        Client client = new JerseyClientBuilder(application.getEnvironment()).build("test-client");
        URI url = application.getConfiguration().getHelloEndpoint();

        Response response = client.target(url)
            .queryParam("name", "ding dang dong")
            .request()
            .accept(MediaType.TEXT_PLAIN)
            .get();

        assertEquals(200, response.getStatus());
        assertEquals("test message>ding dang dong<", response.readEntity(String.class));
    }
}
