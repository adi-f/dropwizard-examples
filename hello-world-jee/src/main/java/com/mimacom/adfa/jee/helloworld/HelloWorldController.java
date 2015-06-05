package com.mimacom.adfa.jee.helloworld;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang3.StringUtils;

@Stateless
@Path("/")
public class HelloWorldController {

    @Resource//(mappedName = "java:global/hello-world/greeting")
    private String greeting;

    @Resource//(mappedName = "java:global/hello-world/defaultName")
    private String defaultName;

    @EJB
    TestBean testBean;

    @GET
    @Path("say-hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello(@QueryParam("name") String name) {
        name = StringUtils.defaultString(name, defaultName);
        return String.format(greeting, name);
    }
}
