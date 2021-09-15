package com.example.integrationproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@PropertySource("classpath:application.properties")
public class KimaiClient {

    @Value("${baseurl}")
    private String baseurl;

    @Autowired
    public RestTemplate restTemplate;

    public List<KimaiEmployee> getAllEmployees() {
        KimaiEmployee[] usersArray = restTemplate.getForObject(baseurl, KimaiEmployee[].class);
        return Arrays.asList(usersArray);
    }

    public KimaiEmployee getById(int id) {
        return restTemplate.getForObject(baseurl + "/" + id, KimaiEmployee.class);
    }

    public KimaiEmployee create(@RequestBody final KimaiEmployee newEmployee) {
        return restTemplate.postForObject(baseurl, newEmployee, KimaiEmployee.class);

    }
}
