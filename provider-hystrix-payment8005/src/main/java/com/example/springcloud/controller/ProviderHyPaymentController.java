package com.example.springcloud.controller;

import com.example.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class ProviderHyPaymentController {
    @Value("${server.port}")
    private String port;

    @Resource
    PaymentHystrixService service;

    @GetMapping("/payment/getPortOK/{id}")
    public String getPortOK(@PathVariable("id") String id ) {
        return service.getPortOK(id)+port;

    }

    @GetMapping("/payment/getPortTimeOut/{id}")
    public String getPortTimeOut(@PathVariable("id") String id) {
        return service.getPortTimeOut(id)+port;
    }

    @GetMapping("/payment/caculator/{id}")
    public String caculator(@PathVariable("id") long id) {
        return service.caculator(id);
    }

}
