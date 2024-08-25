package com.helloSpring.thirdServiceSecurity.configuration;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@AutoConfigureMockMvc
class CustomAuthenticationProviderTest {


    @Mock
    MemoryUserDetailsService memoryUserDetailsService;
    @Mock
    PasswordTextEncoders passwordTextEncoders;
    @InjectMocks
    CustomAuthenticationProvider customAuthenticationProvider;

    @BeforeEach
    public void init (){
        MockitoAnnotations.openMocks(this);
    }
    @AfterEach
    public void close (){
        Mockito.reset(memoryUserDetailsService);
        Mockito.reset(passwordTextEncoders);
    }

    @Test
    public void testAuthentication (){
        String authority = "READ";
        Authentication authentication = new UsernamePasswordAuthenticationToken("username", "password", List.of(()-> authority));
        UserDetails userDetails = new DummyUser("username", "password" , authority);
        when(memoryUserDetailsService.loadUserByUsername("username")).thenReturn(userDetails);
        when(passwordTextEncoders.matches("password", "password")).thenReturn(true);
        Authentication usernamePasswordAuthenticationToken = customAuthenticationProvider.authenticate(authentication);
        assertEquals("password", usernamePasswordAuthenticationToken.getCredentials());
    }

    @Test
    public void testAuthenticationBadAuthentication (){
        String authority = "READ";
        boolean verify =  false;
        Authentication authentication = new UsernamePasswordAuthenticationToken("username", "password", List.of(()-> authority));
        UserDetails userDetails = new DummyUser("username", "password" , authority);
        when(memoryUserDetailsService.loadUserByUsername("username")).thenReturn(userDetails);
        when(passwordTextEncoders.matches("password", "password")).thenReturn(false);
        try{
            Authentication usernamePasswordAuthenticationToken = customAuthenticationProvider.authenticate(authentication);
        }
        catch (BadCredentialsException badCredentialsException){
            verify = true;
            System.out.println(badCredentialsException.getMessage());
        }
        assertTrue(verify);
    }

    @Test
    public void testAuthenticationNUllObject (){
        String authority = "READ";
        boolean verify =  false;
        Authentication authentication = new UsernamePasswordAuthenticationToken("username", "password", List.of(()-> authority));
        UserDetails userDetails = new DummyUser("username", "password" , authority);
        when(memoryUserDetailsService.loadUserByUsername("username")).thenReturn(null);
        when(passwordTextEncoders.matches("password", "password")).thenReturn(false);
        try{
            Authentication usernamePasswordAuthenticationToken = customAuthenticationProvider.authenticate(authentication);
        }
        catch (NullPointerException nullPointerException){
            verify = true;
            System.out.println(nullPointerException.getMessage());
        }
        assertTrue(verify);
    }
}