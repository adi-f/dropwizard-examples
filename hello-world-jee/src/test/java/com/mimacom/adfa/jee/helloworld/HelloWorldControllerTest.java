package com.mimacom.adfa.jee.helloworld;

import static org.junit.Assert.*;

import java.net.URL;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
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
    public void testSayHello() throws Exception {
        System.out.println("test");
    }
}