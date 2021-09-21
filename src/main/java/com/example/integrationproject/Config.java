package com.example.integrationproject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

import org.springframework.stereotype.Service;

@Service
public class Config {

    @Value("${bamboo.authentication}")
    private String bambooAuthentication;

    @Value("${kimai.username}")
    private String kimaiUsername;

    @Value("${kimai.password}")
    private String kimaiPassword;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder
                .defaultHeader("authorization", "Basic " + bambooAuthentication)
                .defaultHeader("X-AUTH-USER", kimaiUsername)
                .defaultHeader("X-AUTH-TOKEN", kimaiPassword)
                .setConnectTimeout(Duration.ofMillis(3000))
                .setReadTimeout(Duration.ofMillis(3000))
                .build();
    }
}
