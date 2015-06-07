package com.mimacom.adfa.dropwizard.helloworldenhanced;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.Response;

import org.junit.ClassRule;
import org.junit.Test;

import io.dropwizard.testing.junit.ResourceTestRule;

public class HelloWorldControllerTest {


    @ClassRule
    public static final ResourceTestRule controller = ResourceTestRule
        .builder()
        //.addResource(new HelloWorldController("This is a %s!", "test"))
        .build();

    @Test
    public void testSayHelloDefault() {
        Response response = controller
            .client()
            .target("/say-hello")
            .request()
            .get();

        assertEquals(200, response.getStatus()); // 200 - OK
        assertEquals("This is a test!", response.readEntity(String.class));
    }

    @Test
    public void testSayHelloParametrized() {
        Response response = controller
            .client()
            .target("/say-hello?name=2nd%20test%20with%20a%20parameter")
            .request()
            .get();

        assertEquals(200, response.getStatus()); // 200 - OK
        assertEquals("This is a 2nd test with a parameter!", response.readEntity(String.class));
    }
}