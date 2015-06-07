package com.mimacom.adfa.jee.helloworld;

import static org.junit.Assert.*;

import javax.ws.rs.client.WebTarget;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.extension.rest.client.ArquillianResteasyResource;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;

import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class HelloWorldControllerTest {

//    @ArquillianResource
//    private URL baseURL; // deployment URL

    @Deployment(testable = false)
    public static WebArchive createDeployment() {

        return ShrinkWrap.create(WebArchive.class).addClasses(
            // classes to add to the deployment
            HelloWorldApplication.class,
            HelloWorldController.class)

            // also add all dependencies from maven
            .addAsLibraries(
                Maven.resolver()
                    .loadPomFromFile("pom.xml")
                    .importRuntimeDependencies()
                    .resolve()
                    .withTransitivity()
                    .asFile());
    }

    @Test
    public void testSayHello(@ArquillianResteasyResource("say-hello") WebTarget webTarget) throws Exception {
        assertEquals("Hello World!", webTarget.request().get(String.class));
    }
}