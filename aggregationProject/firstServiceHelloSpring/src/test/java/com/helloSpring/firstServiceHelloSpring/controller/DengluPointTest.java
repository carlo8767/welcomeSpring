package com.helloSpring.firstServiceHelloSpring.controller;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

// i use SpringBootTest.WebEnvironment to laod the web applicaiton context
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DengluPointTest {


    @Autowired
    TestRestTemplate restTemplate;


    @Test
    public void testDegluPointResponseOk(){
        String url = "/denglu/point?username=FakePippo";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        int value = response.getStatusCode().value();
        assertEquals(200, value);
    }

    @Test
    public void testDegluPointResponseBadRequest(){
        String url = "/denglu/point?test=wrongParam";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        int value = response.getStatusCode().value();
        assertEquals(400, value);
    }

    @Test
    public void testDegluPointResponseInternalServerError(){
        String url = "/denglu/point?username";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        int value = response.getStatusCode().value();
        assertEquals(500, value);
    }

    @Test
    public void testDegluPointResponseBody(){
        String url = "/denglu/point?username=FakePippo";
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        DocumentContext documentContext = JsonPath.parse(responseEntity.getBody());
        // JSON PATH
        String answer = documentContext.read("$[0].username");
        assertEquals("FakePippo", answer);
    }


}