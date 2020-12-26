package com.example.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class OrderZKController {
    @Value("${server.port}")
    String port ;

    public static final String PAYMENT_URL="http://provider-zk-payment";

    @Resource
    RestTemplate restTemplate;

    @GetMapping(value="/consumer/zk/payment")
    public String getZKinfo(){
        return restTemplate.getForObject(PAYMENT_URL+"/zk/payment",
                String.class);
    }


}
