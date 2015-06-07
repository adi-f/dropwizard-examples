package com.mimacom.adfa.jee.helloworld;

import static org.junit.Assert.*;

import java.net.URL;

import javax.servlet.ServletContext;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.apache.commons.lang3.StringUtils;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.extension.rest.client.ArquillianResteasyResource;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.protocol.servlet.arq514hack.descriptors.api.web.WebAppDescriptor;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.StringAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.descriptor.api.Descriptors;

import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class HelloWorldControllerTest {

//    @ArquillianResource
//    private URL baseURL;

//    @ArquillianResource()
//    private ServletContext servletContext;

    @Deployment(testable = false)
    public static WebArchive createDeployment() {


       //  Maven.resolver().loadPomFromFile("pom.xml").importRuntimeDependencies().resolve().withTransitivity().asFile()
        return ShrinkWrap.create(WebArchive.class).addClasses(
            HelloWorldApplication.class,
            HelloWorldController.class,StringUtils.class);
    }

    @Test
    public void testSayHello(@ArquillianResteasyResource("say-hello") WebTarget webTarget) throws Exception {
        assertEquals("Hello World!", webTarget.request().get(String.class));
    }
}