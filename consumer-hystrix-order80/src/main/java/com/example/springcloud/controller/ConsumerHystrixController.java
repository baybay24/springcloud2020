package com.example.springcloud.controller;

import com.example.springcloud.service.HystrixPaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ConsumerHystrixController {

    @Value("${server.port}")
    private long port;

    @Resource
    HystrixPaymentService service;

    @GetMapping("/consumer/hystrix/ok/{id}")
    public String getPortOK(@PathVariable("id") String id) {
        return service.getPortOK(id);
    }


    @GetMapping("/consumer/hystrix/timeout/{id}")
    public String getTimeOut(@PathVariable("id") String id) {
        return service.getPortTimeOut(id);
    }

    @GetMapping("/consumer/hystrix/caculator/{id}")
    public String caculator(@PathVariable("id") long id) {
        return service.caculator(id);
    }
}
