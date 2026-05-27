package com.transport.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PythonService {

    public String getEta() {

        RestTemplate restTemplate = new RestTemplate();

        String response = restTemplate.getForObject(
                "http://localhost:5000/eta",
                String.class
        );

        return response;
    }
}