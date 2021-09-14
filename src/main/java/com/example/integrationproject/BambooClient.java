package com.example.integrationproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BambooClient {
    @Value("${service.url.bamboo.employee}")
    private String baseUri;

    @Autowired
    RestTemplate restTemplate;

    public void addNewEmployee(BambooEmployee newEmployee) {
        restTemplate.postForObject(baseUri, newEmployee, BambooEmployee.class);
    }

}
