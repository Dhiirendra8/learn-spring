package com.client.app.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value="/client-app")
public class ClientAppController {
    @Autowired
    RestTemplate restTemplate;
    
    @Value("${endpoint.server-app}")
    private String msEndpoint;
    
    @RequestMapping(value = "/data", method = RequestMethod.GET)
    public String getData() {
        System.out.println("Returning data from client-app own data method");
        return "Hello from client-app-data method";
    }
    
    @RequestMapping(value = "/ms-data", method = RequestMethod.GET)
    public String getMsData() {
        System.out.println("Got inside client-app-server-data method");
        try {
            System.out.println("MS Endpoint name : [" + msEndpoint + "]");
            
            return restTemplate.getForObject(new URI(msEndpoint), String.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "Exception occurred.. so, returning default data";
    }
}
