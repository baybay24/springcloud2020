package com.example.springcloud.controller;

import com.example.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    String port;

    @Resource
    PaymentService service;

    @GetMapping(value = "/zk/payment")
    public String  getPort(){
        return "ZK-payment-Server-PORT: "+port;
    }
}
