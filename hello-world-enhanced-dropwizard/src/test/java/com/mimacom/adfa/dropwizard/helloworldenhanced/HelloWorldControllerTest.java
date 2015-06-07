package com.mimacom.adfa.dropwizard.helloworldenhanced;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.ClassRule;
import org.junit.Test;

import io.dropwizard.testing.junit.ResourceTestRule;

public class HelloWorldControllerTest {


    @ClassRule
    public static final ResourceTestRule controller = ResourceTestRule
        .builder()
        .addResource(new HelloWorldController("This is a %s!", null, null))
        .build();

    @Test
    public void testSayHelloParametrized() {
        Response response = controller
            .client()
            .target("/say-hello?name=test")
            .request()
            .accept(MediaType.APPLICATION_JSON_TYPE)
            .get();

        assertEquals(200, response.getStatus()); // 200 - OK
        Greeting greeting = response.readEntity(Greeting.class);
        assertEquals("This is a %s!", greeting.getGreeting());
        assertEquals("test", greeting.getName());
    }
}