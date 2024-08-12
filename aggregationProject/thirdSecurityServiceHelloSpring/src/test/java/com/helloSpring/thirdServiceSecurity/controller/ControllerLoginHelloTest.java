package com.helloSpring.thirdServiceSecurity.controller;


import com.helloSpring.thirdServiceSecurity.configuration.ConfigurationBeans;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
// AUTO CONFIGURATION ABOUT THE WEB LAYER
@AutoConfigureMockMvc

class ControllerLoginHelloTest {
    @Autowired
    private MockMvc mvc;
    @Autowired
    private UserDetailsService userDetailsService;


    // TEST AT THE SECURITY LAYER CONTEXT
    @Test
    public void helloUnauthenticated() throws Exception {
        mvc.perform(get("/login/hello"))
         .andExpect(status().isUnauthorized());
    }

    // SET A MOCK USER IN SECURITY CONTEXT
    @WithMockUser
    @Test
    public void helloUnauthenticatedoK() throws Exception {
        mvc.perform(get("/login/hello"))
                .andExpect(content().string("hello!"))
                .andExpect(status().isOk());

    }
}