package com.example.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class OrderConsulController {
    @Value("${server.port}")
    private String port;

    private final String Consul_URL = "http://provider-consul-payment";

    @Resource
    RestTemplate restTemplate;

    @GetMapping(value = "/consul/payment")
    public String getServiceInfo() {
        return restTemplate.getForObject(Consul_URL+"/consul/payment",String.class);
    }


}
