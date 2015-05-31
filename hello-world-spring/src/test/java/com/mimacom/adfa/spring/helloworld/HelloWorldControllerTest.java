package com.mimacom.adfa.spring.helloworld;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HelloWorldApplication.class)
@WebIntegrationTest({"greeting=This is a %s!", "defaultName=test", "server.port=0"})
public class HelloWorldControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testSayHelloDefault() throws Exception {
        String greeting = mockMvc
            .perform(get("/say-hello"))
            .andExpect(status().isOk()) // 200 - OK
            .andReturn()
            .getResponse()
            .getContentAsString();

        assertEquals("This is a test!", greeting);
    }

    @Test
    public void testSayHelloParametrized() throws Exception {
        String greeting = mockMvc
            .perform(get("/say-hello?name=2nd test with a parameter"))
            .andExpect(status().isOk()) // 200 - OK
            .andReturn()
            .getResponse()
            .getContentAsString();

        assertEquals("This is a 2nd test with a parameter!", greeting);
    }
}