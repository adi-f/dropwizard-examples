package com.mimacom.adfa.jee.helloworld;

import java.util.Collections;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/")
public class HelloWorldApplication extends Application{

//    @Override
//    public Set<Class<?>> getClasses() {
//        return Collections.singleton(HelloWorldController.class);
//    }
}
