package com.helloSpring.firstServiceHelloSpring.controller;

import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.ResponseEntity;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ControllerElectionTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    public void  testGetTypeElection (){
        String url = "/election/typeElection?nameElection=fakeElection&dateElection=2019-02-29";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        int value = response.getStatusCode().value();
        assertEquals(200, value);
    }

    @Test
    public void  testResponseElection (){
        ControllerElectionImpl s = new ControllerElectionImpl();
        s.getTypeElection("fakeElection", "2019-02-29");
    }

    @Test
    public void  testResponseGetTypeElection (){
        String url = "/election/typeElection?nameElection=fakeElection&dateElection=2019-02-29";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        // JSON PATH
        String jsonBody = JsonPath.read(response.getBody(),"$.localDateTime");
        assertEquals("2019-02-29", jsonBody);
    }
}