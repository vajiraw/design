package com.indigo.fashion;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class BasicConfigurationIntegrationTest {
	
	TestRestTemplate restTemplate;
    URL base;
    @LocalServerPort int port=8080;

//    @BeforeAll
//    public void setUp() throws MalformedURLException {
//        restTemplate = new TestRestTemplate("user", "password");
//        base = new URL("http://localhost:" + port +"/login ");
//    }
    
    
    @Test
    public void whenLoggedUserRequestsHomePage_ThenSuccess()
     throws IllegalStateException, IOException {
        ResponseEntity<String> response =
          restTemplate.getForEntity(base.toString(), String.class);
 
        org.junit.jupiter.api.Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        //org.junit.jupiter.api.Assertions.assertTrue(response.getBody().contains("Baeldung"));
    }

    @Test
    public void whenUserWithWrongCredentials_thenUnauthorizedPage() 
      throws Exception {
 
        restTemplate = new TestRestTemplate("user", "wrongpassword");
        ResponseEntity<String> response =
          restTemplate.getForEntity(base.toString(), String.class);
 
        org.junit.jupiter.api.Assertions.assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
        org.junit.jupiter.api.Assertions.assertTrue(response.getBody().contains("Unauthorized"));
    }

}
