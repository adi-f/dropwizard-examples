package com.mimacom.adfa.spring.helloworld;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @Value("${greeting}")
    private String greeting;

    @Value("${defaultName}")
    private String defaultName;

    @RequestMapping(value = "/say-hello", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public String sayHello(@RequestParam(required = false) String name) {
        name = StringUtils.defaultString(name, defaultName);
        return String.format(greeting, name);
    }
}
