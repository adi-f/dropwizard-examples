package com.mimacom.adfa.dropwizard.helloworld;

import static org.junit.Assert.assertEquals;

import org.junit.ClassRule;
import org.junit.Test;

import io.dropwizard.testing.junit.ResourceTestRule;

public class HelloWorldControllerTest {


    @ClassRule
    public static final ResourceTestRule controller = ResourceTestRule
        .builder()
        .addResource(new HelloWorldController("This is a %s!", "test"))
        .build();

    @Test
    public void testSayHelloDefault() throws Exception {
        String greeting = controller
            .client()
            .target("/say-hello")
            .request()
            .get()
            .readEntity(String.class);
        assertEquals("This is a test!", greeting);
    }

    @Test
    public void testSayHelloParametrized() throws Exception {
        String greeting = controller
            .client()
            .target("/say-hello?name=2nd%20test%20with%20a%20parameter")
            .request()
            .get()
            .readEntity(String.class);
        assertEquals("This is a 2nd test with a parameter!", greeting);
    }
}