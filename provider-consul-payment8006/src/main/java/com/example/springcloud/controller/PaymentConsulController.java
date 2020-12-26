package com.example.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController

public class PaymentConsulController {

    @Value("${server.port}")
    private String port;

    @GetMapping(value= "/consul/payment")
    public String  registerService() {
        return "Springcloud with consul: "+port+ UUID.randomUUID().toString();
    }

}
