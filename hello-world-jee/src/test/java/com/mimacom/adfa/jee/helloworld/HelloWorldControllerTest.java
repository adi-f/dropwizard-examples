package com.mimacom.adfa.jee.helloworld;

import static org.junit.Assert.*;

import java.net.URL;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.extension.rest.client.ArquillianResteasyResource;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class HelloWorldControllerTest {

//    @ArquillianResource
//    private URL webappUrl;

    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class).addClasses(
            HelloWorldApplication.class,
            HelloWorldController.class);
    }

    @Test
    public void testSayHello(@ArquillianResteasyResource WebTarget webTarget) throws Exception {
        WebTarget path = webTarget.path("say-hello");
        Invocation.Builder request = path.request();
        String result = request.get(String.class);

        // String result = webTarget.path("say-hello").request().get(String.class);
        assertEquals("Hello World!", result);
    }
}